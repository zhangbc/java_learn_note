package com.runoob;

import java.io.*;
import java.net.Socket;

/**
 * Socket编程--客户端实例
 * @author 张伯成
 * @date 2019/3/7 14:26
 */
public class GreetingClient {
    public static void main(String[] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            System.out.println("连接到主机：" + serverName + ", 端口号：" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outServer = client.getOutputStream();
            DataOutputStream outData = new DataOutputStream(outServer);

            outData.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream inData = new DataInputStream(inFromServer);
            System.out.println("服务器响应：" + inData.readUTF());
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
