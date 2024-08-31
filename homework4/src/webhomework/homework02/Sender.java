package webhomework.homework02;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

//（ 1 ）编写一个接收端 A ，和一个发送端 B ，使用 UDP 协议完成
//（ 2 ）接收端在 8888 端口等待接收数据（ receive ）
//（ 3 ）发送端向接收端发送数据"四大名著是哪些"
//（ 4 ）接收端接收到发送端发送的问题后，返回"四大名著是<<红楼梦>>,,,",否则返回what？
//（ 5 ）接收端和发送端程序退出
public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8887);
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        byte[] byte1 = str1.getBytes();
        DatagramPacket packet = new DatagramPacket(byte1,byte1.length, InetAddress.getLocalHost(),8888);
        socket.send(packet);

        System.out.println("等待回答");
        byte[] buffer = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(buffer,buffer.length);
        socket.receive(packet2);

        int length = packet2.getLength();
        byte[] buffer2 = packet2.getData();
        String s = new String(buffer2,0,length);
        System.out.println(s);

        socket.close();

    }
}
