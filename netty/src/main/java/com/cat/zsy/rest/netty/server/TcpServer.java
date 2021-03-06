package com.cat.zsy.rest.netty.server;

import io.netty.bootstrap.*;
import io.netty.buffer.*;
import io.netty.channel.*;
import io.netty.channel.nio.*;
import io.netty.channel.socket.nio.*;
import io.netty.handler.codec.serialization.*;
import io.netty.handler.logging.*;
import org.slf4j.*;

public final class TcpServer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final int SO_BACKLOG = 1 << 10;
    private static final int CONNECT_TIMEOUT_MILLIS = 1000;
    private static final int SO_SNDBUF = 1 << 20;

    private void init(String host, int port) {
        ServerBootstrap bootstrap = new ServerBootstrap();

        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup handleGroup = new NioEventLoopGroup();

        //setting options
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.option(ChannelOption.TCP_NODELAY, true);
        bootstrap.option(ChannelOption.SO_SNDBUF, SO_SNDBUF);
        bootstrap.option(ChannelOption.SO_BACKLOG, SO_BACKLOG);
        bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, CONNECT_TIMEOUT_MILLIS);

        //pool
        bootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
        bootstrap.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

        //logging
        bootstrap.childHandler(new LoggingHandler(LogLevel.WARN));

        bootstrap.group(mainGroup, handleGroup).channel(NioServerSocketChannel.class);

        //handler
        bootstrap.childHandler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(
                        new ObjectEncoder(),
                        new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.weakCachingResolver(null)),
                        new FileUploadHandler()
                );
            }
        });

        try {
            Channel channel = bootstrap.bind(host, port).sync().channel();

            logger.info("{}[{}:{}]启动成功", this.getClass().getSimpleName(), host, port);

            channel.closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mainGroup.shutdownGracefully();
            handleGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new TcpServer().init("localhost", 9999);
    }

}
