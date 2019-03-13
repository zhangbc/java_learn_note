package com.runoob;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.lang.Thread;

/**
 * Socket编程--服务端实例
 * @author 张伯成
 * @date 2019/3/7 15:09
 */
public class GreetingServer extends Thread {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            Thread thread = new GreetingServer(port);
            thread.run();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("等待远程连接，端口号为："
                        + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                DataInputStream inData = new DataInputStream(server.getInputStream());
                System.out.println(inData.readUTF());

                DataOutputStream outData = new DataOutputStream(server.getOutputStream());
                outData.writeUTF("谢谢连接我：" + server.getLocalSocketAddress()
                        + "\nGoodbye!");
                server.close();
            } catch (SocketTimeoutException es) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException ex) {
                ex.printStackTrace();
                break;
            }
        }
    }
}
