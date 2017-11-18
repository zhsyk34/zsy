import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class ChannelTest {

    @Test
    public void test12() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("E:\\logs2\\xxx/current.log", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(100);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    @Test
    public void test2() throws Exception {
        FileChannel from = new RandomAccessFile("fromFile.txt", "rw").getChannel();

        FileChannel to = new RandomAccessFile("toFile.txt", "rw").getChannel();

        long position = 0;
        long count = from.size();

        to.transferFrom(from, position, count);
    }

    @Test
    public void test3() throws Exception {
        FileChannel from = new RandomAccessFile("fromFile.txt", "rw").getChannel();

        FileChannel to = new RandomAccessFile("toFile.txt", "rw").getChannel();

        long position = 0;
        long count = from.size();

        from.transferTo(position, count, to);
    }

    @Test
    public void test4() throws Exception {
        Selector selector = Selector.open();

        SocketChannel channel = null;
        channel.configureBlocking(false);

        channel.register(selector, SelectionKey.OP_READ);

        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }

            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.

                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.

                } else if (key.isReadable()) {
                    // a channel is ready for reading

                } else if (key.isWritable()) {
                    // a channel is ready for writing
                }

                keyIterator.remove();
            }
        }
    }

    @Test
    public void test5() throws Exception {

    }
}
