package API;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//1 ·编写一个服务端，和一个客户端
//2 ·服务器端在 9999 端口监听
//3 ·客户端连接到服务端，发送 "hello, server" ，井接收服务器端回发的"hello,client", 再退出
//4 ·服务器端接收到客户端发送的信息，输出，并发送 "hello, client", 再退出
public class socketTCPserver02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器等待连接，，，");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        //设置写入结束标记
        socket.shutdownOutput();
        //关闭
        outputStream.close();
        serverSocket.close();
        socket.close();
        inputStream.close();


    }
}
