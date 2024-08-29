package API;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 1 ·编写一个服务器端和一个客户端
// 2 ·服务器端在 9999 端口监听
// 3 ·客户端连接到服务器端，发送 "hello, server" ，然后退出
// 4 ·服务器端接收到客户端发送的信息，输出，并退出

//服务器
public class socketTCPserver {
    public static void main(String[] args) throws IOException {
        //要求本机没有其他服务监听9999
        //ServerSocket可以通过accept返回多个socket[](多并发
        ServerSocket serverSocket = new ServerSocket(9999);
        //如有客户端连接 返回accept对象
        System.out.println("等待连接，，，");
        //程序阻塞，客户端链接才继续
        Socket accept = serverSocket.accept();
        System.out.println(accept.getClass());
        //输入
        InputStream inputStream = accept.getInputStream();
        //读取
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = inputStream.read(buffer)) != -1){
            System.out.println(new String(buffer,0,len));
        }
        serverSocket.close();
        inputStream.close();
        accept.close();



    }
}
