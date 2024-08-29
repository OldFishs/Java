package API;

//1 ·编写一个服务端，和一个客户端
//2 ·服务器端在 9999 端口监听
//3 ·客户端连接到服务端，发送 "hello, server" ，井接收服务器端回发的"hello,client", 再退出
//4 ·服务器端接收到客户端发送的信息，输出，并发送 "hello, client", 再退出

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.function.DoubleToIntFunction;

public class socketTCPclient02 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        OutputStream os = socket.getOutputStream();
        os.write("Hello server".getBytes());
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int read = 0;
        while((read = is.read(buffer)) != -1){
            System.out.println(new String(buffer,0,read));;
        }
        socket.close();
        os.close();
        is.close();
        System.out.println("客户端退出");

    }
}
