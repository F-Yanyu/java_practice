package org.example.project.NetworkProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);// 监听6666端口,要求端口没有被占用
        System.out.println("监听6666端口中。。。");
        /*
        当没有客户端链接6666端口时，程序会阻塞，等待连接
        如果有客户端连接，则会返回Socket对象，程序继续
         */
        Socket accept = serverSocket.accept();
        System.out.println("server is running...");
        // 通过socket.getInputStream() 读取客户端写入数据通道的数据，显示
        InputStream inputStream = accept.getInputStream();
        // io读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf,0,readLen));
        }
        // 关闭流和socket
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
