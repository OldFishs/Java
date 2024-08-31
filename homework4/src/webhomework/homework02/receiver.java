package webhomework.homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

////（ 1 ）编写一个接收端 A ，和一个发送端 B ，使用 UDP 协议完成
////（ 2 ）接收端在 8888 端口等待接收数据（ receive ）
////（ 3 ）发送端向接收端发送数据"四大名著是哪些"
////（ 4 ）接收端接收到发送端发送的问题后，返回"四大名著是<<红楼梦>>,,,",否则返回what？
////（ 5 ）接收端和发送端程序退出
public class receiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        System.out.println("等待接受数据，，，");

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        socket.receive(packet);

        int line = packet.getLength();
        byte[] data = packet.getData();
        String str = new String(data,0,line);
        System.out.println(str);


        if(str.equals("四大名著是哪些")){
            byte[] buf1 = "红楼梦，西游记，，，，，".getBytes();
            DatagramPacket packet1 = new DatagramPacket(buf1,buf1.length, InetAddress.getLocalHost(),8887);
            socket.send(packet1);
        }else{
            byte[] buf2 = "what??".getBytes();
            DatagramPacket packet1 = new DatagramPacket(buf2,buf2.length, InetAddress.getLocalHost(),8887);
        }
        socket.close();
    }
}
