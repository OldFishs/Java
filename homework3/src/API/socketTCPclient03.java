package API;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


//使用字符流
//(使用转换流)
//1 ．编写一个服务端，和一个客户端
//2 ·服务端在 9999 端口监听
//3 ·客户端连接到服务端，发送 "hello, server" ，井接收服务端回发的"hello，client"，再退出
//4 ·服务端接收到客户端发送的信息，输出，并发送 "hello, client", 再退出
@SuppressWarnings({"all"})
public class socketTCPclient03 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write("hello,server");
        //使用字符流需要手动刷新
        bw.flush();
        //设置写入结束标记
        //(结束标志：write.newline 需要用readline)
        socket.shutdownOutput();
        //bw.newLine();

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = "";
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        socket.close();
        bw.close();
        br.close();
        System.out.println("客户端退出");

    }
}
