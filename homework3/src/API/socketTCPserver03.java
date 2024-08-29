package API;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//使用字符流
//(使用转换流)
//1 ．编写一个服务端，和一个客户端
//2 ·服务端在 9999 端口监听
//3 ·客户端连接到服务端，发送 "hello, server" ，井接收服务端回发的"hello，client"，再退出
//4 ·服务端接收到客户端发送的信息，输出，并发送 "hello, client", 再退出
public class socketTCPserver03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器等待连接，，，");
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String len = " ";
        while ((len = br.readLine()) != null) {
            System.out.println(len);
        }

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("hello,client");
        bw.flush();
        //设置写入结束标记
        //(结束标志：write.newline 需要用readline)
        socket.shutdownOutput();
        //bw.newLine();
        //关闭
        serverSocket.close();
        socket.close();
        br.close();
        bw.close();
    }
}
