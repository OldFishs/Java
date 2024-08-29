package API;


// 1 ·编写一个服务器端和一个客户端
// 2 ·服务器端在 9999 端口监听
// 3 ·客户端连接到服务器端，发送 "hello, server" ，然后退出
// 4 ·服务器端接收到客户端发送的信息，输出，并退出

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//客户端
public class socketTCPclient {
    public static void main(String[] args) throws IOException {

        //连接该机的9999 如链接成功返回socket对象(链接对象，端口）
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println(socket.getClass());
        //输出
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        outputStream.close();
        socket.close();
        System.out.println("客户端退出，，，");


    }
}
