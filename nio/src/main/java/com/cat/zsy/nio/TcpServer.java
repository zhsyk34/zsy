package com.cat.zsy.nio;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

@RequiredArgsConstructor
public class TcpServer {

    private final Selector selector;
    private final int port;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) throws IOException {
//        ExecutorService service = Executors.newCachedThreadPool();
        TcpServer tcpServer = new TcpServer(Selector.open(), 9999);
        tcpServer.startup();
    }

    public static void startServer(int port) throws IOException {
        // 打开服务端ServerSocketChannel
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        // 设置为非阻塞模式
        serverChannel.configureBlocking(false);
        // 绑定一个本地端口，这样客户端便可以通过这个端口连接到服务器
        serverChannel.bind(new InetSocketAddress(port));

        // 打开selector
        Selector selector = Selector.open();
        // 注意关心的事件是OP_ACCEPT，表示只关心接受事件即接受客户端到服务器的连接
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // select()阻塞直到注册的某个事件就绪并会更新SelectionKey的状态
            int readyChannels = selector.select();
            if (readyChannels <= 0) {
                continue;
            }

            // 得到就绪的key集合，key中保存有就绪的事件以及对应的Channel通道
            Set<SelectionKey> SelectorKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterator = SelectorKeySet.iterator();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 遍历选择键
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    // 处理accept事件
                    SocketChannel socketChannel = serverChannel.accept();
                    socketChannel.configureBlocking(false);
                    // 注意此处新增关心事件OP_READ
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    // 处理read事件
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    buffer.clear();
                    socketChannel.read(buffer);
                    buffer.flip();
                    socketChannel.write(buffer);
                }
                iterator.remove();
            }
        }
    }

    public void startup() {
        try {
            ServerSocketChannel server = ServerSocketChannel.open();

            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            server.register(selector, SelectionKey.OP_ACCEPT);

            //loop
            while (true) {
                this.selector.select();

                Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                        SocketChannel client = channel.accept();

                        logger.debug("accept client:{}", client);
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1 << 10));
                        logger.debug("listen client msg...");
                    }
                    if (key.isReadable()) {
                        SocketChannel client = (SocketChannel) key.channel();

                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        buffer.clear();
                        int read = client.read(buffer);

                        if (read < 0) {
                            key.cancel();
                            client.close();
                        } else if (read > 0) {
                            String r = fromByteBuffer(buffer);
                            logger.debug("receive msg {} from client {}", r, client.getRemoteAddress());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String fromByteBuffer(ByteBuffer buffer) {
        buffer.flip();
        if (buffer.hasArray()) {
            return new String(buffer.array(), 0, buffer.limit(), StandardCharsets.UTF_8);
        }
        byte[] bytes = new byte[buffer.remaining()];
        buffer.duplicate().get(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private String fromByteBuffer2(ByteBuffer buffer) {
        buffer.flip();
        return Charset.defaultCharset().decode(buffer).toString();
    }

}
