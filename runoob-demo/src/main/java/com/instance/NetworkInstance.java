package com.instance;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Java网络实例
 * @author zhangbocheng
 * @version 1.0
 * @date 2019/3/15 11:24
 */
public class NetworkInstance {
    public static void main(String[] args) {
        System.out.println("Java网络实例！");
    }
}


/**
 * 获取指定主机的IP地址：
 * 使用InetAddress类的InetAddress.getByName()方法来获取指定主机（网址）的IP地址.
 */
class HostIP {
    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
            System.exit(2);
        }

        System.out.println(address.getHostName() + " ，IP为： " + address.getHostAddress());
    }
}


/**
 * 查看端口是否被占用
 */
class NetPortUsed {
    public static void main(String[] args) {
        int length = 1500;
        String host = "localhost";
        if (args.length > 0) {
            host = args[0];
        }

        for (int i = 1430; i < length; i++) {
            try {
                System.out.println("查看端口：" + i);
                new Socket(host, i);
                System.out.println("端口" +   i + "已被占用.");
            } catch (UnknownHostException euk) {
                System.out.println("Error: " + euk.toString());
            } catch (IOException e) {
                System.out.println("Error: " + e.toString());
                //e.printStackTrace();
            }
        }
    }
}


/**
 * 获取本机ip地址及主机名：
 * 使用InetAddress类的getLocalAddress()方法获取本机ip地址及主机名.
 */
class LocalHostIP {
    public static void main(String[] args) throws Exception {
        InetAddress addr = InetAddress.getLocalHost();
        String hostName = addr.getHostName();
        System.out.println("Local host address：" + addr.getHostAddress());
        System.out.println("Local host name：" + hostName);
    }
}


/**
 * 获取远程文件大小
 */
class RemoteFileSize {
    public static void main(String[] args) throws Exception {
        int size;
        URL url = new URL("http://www.runoob.com/wp-content/themes/runoob/assets/img/newlogo.png");
        URLConnection conn = url.openConnection();
        size = conn.getContentLength();
        if (size < 0) {
            System.out.println("无法获取文件大小.");
        } else {
            System.out.println("文件大小为(bytes)：" + size);
        }
        conn.getInputStream().close();
    }
}


/**
 * Socket实现多线程服务器程序
 */
class MultiThreadServer implements Runnable {
    Socket cSocket;
    MultiThreadServer(Socket cSocket) {
        this.cSocket = cSocket;
    }

    public static void main(String[] args) throws Exception {
        ServerSocket sSock = new ServerSocket(1234);
        System.out.println("Listening...");
        while (true) {
            Socket sock = sSock.accept();
            System.out.println("Connected.");
            new Thread(new MultiThreadServer(sock)).start();
        }
    }

    public void run() {
        try {
            PrintStream printStream = new PrintStream(cSocket.getOutputStream());
            int counts = 100;
            for (int i = 0; i <= counts; i++) {
                printStream.println(i + " bottles of beer on the wall.");
            }
            printStream.close();
            cSocket.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}


/**
 * 查看主机指定文件的最后修改时间
 */
class RemoteFileModifiedTime {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://127.0.0.1/java.html");
        URLConnection uc = url.openConnection();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        uc.setUseCaches(false);
        long timestamp = uc.getLastModified();
        System.out.println("文件最后修改时间：" + sdf.format(new Date(timestamp)));
    }
}


/**
 * 使用Socket连接到指定主机：
 * 使用net.Socket类的getInetAddress()方法来连接到指定主机.
 */
class SocketLinkedHost {
    public static void main(String[] args) {
        try {
            InetAddress addr;
            Socket socket = new Socket("www.runoob.com", 80);
            addr = socket.getInetAddress();
            System.out.println("链接到 " + addr);
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.toString());
        }
    }
}


/**
 *  网页抓取：
 *  使用net.URL类的URL()构造函数来抓取网页.
 */
class Crawl {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.runoob.com");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}


/**
 * 获取 URL响应头的日期信息：
 * 使用HttpURLConnection的httpCon.getDate()方法来获取URL响应头的日期信息.
 */
class ResponseDate {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://runoob.com");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        long date = httpCon.getDate();
        if (date == 0) {
            System.out.println("无法获信息。");
        } else {
            System.out.println("URL Response Date: " + new Date(date));
        }
    }
}


/**
 * 获取URL响应头信息
 */
class ResponseInfo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://runoob.com");
        URLConnection conn = url.openConnection();

        Map headers = conn.getHeaderFields();
        Set<String> keys = headers.keySet();
        for (String key: keys) {
            String value = conn.getHeaderField(key);
            System.out.println(key + "：" + value);
        }

        System.out.println(conn.getLastModified());
    }
}


/**
 * 解析 URL：
 * 使用net.URL类的url.getProtocol(), url.getFile()等方法来解析URL地址.
 */
class UrlParse {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.runoob.com/html/html-tutorial.html");
        System.out.println("URL是：" + url.toString());
        System.out.println("协议是：" + url.getProtocol());
        System.out.println("文件名是：" + url.getFile());
        System.out.println("主机是：" + url.getHost());
        System.out.println("路径是：" + url.getPath());
        System.out.println("端口号是：" + url.getPort());
        System.out.println("默认端口号是：" + url.getDefaultPort());
    }
}


/**
 * ServerSocket和Socket通信实例：
 * 实现客户端发送消息到服务器，服务器接收到消息并读取输出，
 * 然后写出到客户端客户端接收到输出.
 *
 * 1) 建立服务器端:
 * 服务器建立通信ServerSocket
 * 服务器建立Socket接收客户端连接
 * 建立IO输入流读取客户端发送的数据
 * 建立IO输出流向客户端发送数据消息
 */
class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket sSocket = new ServerSocket(8081);
            System.out.println("启动服务器...");
            Socket socket = sSocket.accept();
            System.out.println("客户端：" + socket.getInetAddress().getLocalHost() +
                    "已连接到服务器.");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String msg = reader.readLine();
            System.out.println("客户端：" + msg);

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            writer.write(msg + "\n");
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


/**
 * 2) 建立客户端
 */
class SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8081);

            // 构建IO
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
            // 向服务器端发送一条消息
            writer.write("测试客户端和服务器通信，服务器接收到消息返回到客户端.\n");
            writer.flush();

            // 读取服务器返回的消息
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String msg = reader.readLine();
            System.out.println("服务器：" + msg);
        } catch (UnknownHostException eh) {
            eh.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}