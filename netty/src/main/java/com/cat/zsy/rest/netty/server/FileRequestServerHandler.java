//package com.cat.zsy.netty.server;
//
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.SimpleChannelInboundHandler;
//import io.netty.handler.stream.ChunkedFile;
//
//import java.nio.channels.FileChannel;
//
//public class FileRequestServerHandler extends SimpleChannelInboundHandler<FileChannel> {
//
//    private File f;
//    private Logger logger = Logger.getLogger(this.getClass());
//
//    @Override
//    public void channelRead0(ChannelHandlerContext ctx, FileRequestProtocol fileRequest) {
//        logger.info("Server new FileRequest " + fileRequest);
//        f = new File(fileRequest.getFilePath());
//        fileRequest.setFileSize(f.length());
//        ctx.writeAndFlush(fileRequest);
//
//        // directly make your chunkedFile there instead of creating a sub handler
//        chunkedFile = new ChunkedFile(this.file);
//        ctx.writeAndFlush(chunkedFile);// need a specific handler
//        // Don't create such an handler: new ChunkedFileServerHandler(ctx,f);
//    }