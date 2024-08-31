package webhomework.homework01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//（ 1 ）使用字符流的方式，编写一个客户端程序和服务器端程序，
//（ 2 ）客户端发送 "name", 服务器端接收到后，返回"我是nova ",nova 是你自己的名字·
//（ 3 ）客户端发送 "hobby", 服务器端接收到后，返回"编写java程序"
//（ 4 ）不是这两个问题，回复"你说啥呢"
@SuppressWarnings({"all"})
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器等待连接，，，");
        Socket socket = serverSocket.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s= br.readLine();
        //char[] s = br.readLine().toCharArray();
        BufferedWriter bw = null;
        if(s.equals("name")){
            System.out.println(s);
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("我是nova");
            bw.flush();
            socket.shutdownOutput();
        }else if(s.equals("hobby")){
            System.out.println(s);
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("写该死的java项目");
            bw.flush();
            socket.shutdownOutput();
        }else{
            System.out.println(s);
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("你他妈在讲什么东西");
            bw.flush();
            socket.shutdownOutput();
        }
        br.close();
        bw.close();
        socket.close();
     }
}
