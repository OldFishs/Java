package API;

import java.io.IOException;
import java.net.*;

//1 ·编写一个接收端 A ，和一个发送端 B
//2 ·接收端 A 在 9999 端口等待接收数据（receive）
//3 ·发送端 B 向接收端 A 发送数据 "hello ，明天吃火锅“
//4 ·接收端 A 接收到发送端 B 发送的数据，回复''好的，明天见"，再退出
//5 ·发送端接收 回复的数据，再退出
public class UDPsender {
    public static void main(String[] args) throws IOException {
        //接收端
        DatagramSocket socket = new DatagramSocket(9998);

        //打包发送
        byte[] buf = "hello,吃火锅".getBytes();
        //（封装对象byte数组,data.length,主机ip，端口）
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 9999);
        //DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByname(xxxxxxxxx), 9999);
        //更符合实际开发
        socket.send(packet);

        //接受
        System.out.println("等待回答");
        byte[] byte1 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(byte1, byte1.length);
        socket.receive(packet1);

        //拆包打印
        int length = packet1.getLength();
        byte[] buf1 = packet1.getData();
        String s = new String(buf1, 0, length);
        System.out.println(s);

        socket.close();


    }
}
