package webhomework.homework03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//（ 1 ）编写客户端程序和服务器端程序
// （ 2 ）客户端可以输入一个音乐文件名比如高山流水，服务端收到音乐名后给客户端返回这个音乐文件，
// 如果服务器没有这个文件，返回一个默认的音乐即可·
// （ 3 ）客户端收到文件后，保存到本地 d:\\
// （ 4 ）提示：该程序可以使用 StreamUtiIs.java
//
public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("干劲说话：");
        String name = sc.next();
        //连接服务区
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        OutputStream outputStream = socket.getOutputStream();
        //发送
        outputStream.write(name.getBytes());
        outputStream.flush();
        socket.shutdownOutput();

        //接受
        BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
        byte[] s = StreamUtils.streamToByteArray(inputStream);
        //输出流，把文件写入磁盘
        String s1 = "d:\\" + name + ".txt";
        BufferedOutputStream bis = new BufferedOutputStream(new FileOutputStream(s1));
        bis.write(s);
        bis.flush();
        socket.shutdownInput();

        inputStream.close();
        bis.close();
        socket.close();



    }
}
