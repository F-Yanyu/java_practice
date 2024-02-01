package org.example.project.NetworkProgramming;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        // 1. 连接服务端（ip，端口号）
        // 解读：连接本机的6666端口，如果连接成功返回socket对象
        Socket serverSocket = new Socket(InetAddress.getLocalHost(),6666);
        System.out.println("客户端 socket返回=" + serverSocket.getClass());
        // 2. 连接成功后，生成socket，通过socket.getOutStream()得到 和 socket对象关联的输出流对象
        OutputStream outputStream = serverSocket.getOutputStream();
        // 3. 通过输出流，写入数据到 数据通道
        outputStream.write("hello,server".getBytes());
        // 4. 关闭流对象和socket，必须关闭
        outputStream.close();
        serverSocket.close();
        System.out.println("客户端退出。。。");
    }
}
