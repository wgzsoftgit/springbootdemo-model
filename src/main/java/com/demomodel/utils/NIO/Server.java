package com.demomodel.utils.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import com.sun.star.io.IOException;


/**
 * nio是面向缓冲区的
 * bio是面向流的
 * @author zmrwego
 * @descreption
 * @create 2018-10-15
 **/

public class Server {
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);//调整缓冲区大小为1024字节
    private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
    String str;

    public void start() throws java.io.IOException, IOException  {
        //打开服务器套接字通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false); //服务器配置为非阻塞 即异步IO
        ssc.bind(new InetSocketAddress(3400)); //绑定本地端口   向Selector对象绑定通道 
        //创建选择器  创建Selector对象
        selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);//ssc注册到selector准备连接   向Selector中注册感兴趣的事件
        //无限判断当前线程状态，如果没有中断，就一直执行while内容。
        while(! Thread.currentThread().isInterrupted()){
        //	该调用会阻塞，直到至少有一个事件就绪、准备发生 
            selector.select(); //select()方法返回的值表示有多少个 Channel 可操作
         // 一旦上述方法返回，线程就可以处理这些事件
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()){//处理客户端连接
                SelectionKey key = keyIterator.next();
                if (!key.isValid()){
                    continue;
                }
                if (key.isAcceptable()){
                    accept(key);
                }
                if(key.isReadable()){
                    read(key);
                }
                if (key.isWritable()){
                    write(key);
                }
                keyIterator.remove(); //移除当前的key
            }
        }


    }
    private void read(SelectionKey key) throws java.io.IOException  {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        this.readBuffer.clear();//清除缓冲区，准备接受新数据
        int numRead;
        try{
            numRead = socketChannel.read(this.readBuffer);
        }catch (Exception e){
            key.cancel();
            socketChannel.close();
            return;
        }
        str = new String(readBuffer.array(),0,numRead);
        System.out.println(str);
        socketChannel.register(selector,SelectionKey.OP_WRITE);

    }
    private void write(SelectionKey key) throws IOException, java.io.IOException{
        SocketChannel channel = (SocketChannel) key.channel();
        System.out.println("write:"+str);

        sendBuffer.clear();
        sendBuffer.put(str.getBytes());
        sendBuffer.flip();//反转，由写变为读
        channel.write(sendBuffer);
        //注册读操作 下一次进行读
        channel.register(selector,SelectionKey.OP_READ);
    }
    private void accept(SelectionKey key) throws IOException, java.io.IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = ssc.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("a new client connected "+clientChannel.getRemoteAddress());
    }

    public static void main(String[] args) throws Exception {
        System.out.println("sever start...");
        new Server().start();
    }
}