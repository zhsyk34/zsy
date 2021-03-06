package com.cat.zsy.nio.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;

public class TCPServerSelector {
    //缓冲区的长度  
    private static final int BUF_SIZE = 1 << 10;
    //select方法等待信道准备好的最长时间  
    private static final int TIMEOUT = 3000;

    public static void main(String[] args) throws IOException {
        //创建一个选择器
        Selector selector = Selector.open();
        //实例化一个信道
        ServerSocketChannel server = ServerSocketChannel.open();
        //将该信道绑定到指定端口
        server.bind(new InetSocketAddress(9999));
        //配置信道为非阻塞模式
        server.configureBlocking(false);
        //将选择器注册到各个信道
        server.register(selector, SelectionKey.OP_ACCEPT);

        //创建一个实现了协议接口的对象
        TCPProtocol protocol = new EchoSelectorProtocol(BUF_SIZE);
        //不断轮询select方法，获取准备好的信道所关联的Key集  
        while (true) {
            //一直等待,直至有信道准备好了I/O操作  
            if (selector.select(TIMEOUT) == 0) {
                //在等待信道准备的同时，也可以异步地执行其他任务，  
                //这里只是简单地打印"."  
                System.out.print(".");
                continue;
            }
            //获取准备好的信道所关联的Key集合的iterator实例  
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            //循环取得集合中的每个键值  
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                //如果服务端信道感兴趣的I/O操作为accept  
                if (key.isAcceptable()) {
                    protocol.handleAccept(key);
                }
                //如果客户端信道感兴趣的I/O操作为read  
                if (key.isReadable()) {
                    protocol.handleRead(key);
                }
                //如果该键值有效，并且其对应的客户端信道感兴趣的I/O操作为write  
                if (key.isValid() && key.isWritable()) {
                    protocol.handleWrite(key);
                }
                //这里需要手动从键集中移除当前的key  
                keyIterator.remove();
            }
        }
    }
}  