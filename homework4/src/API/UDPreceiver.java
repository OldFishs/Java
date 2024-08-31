package API;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

////1 ·编写一个接收端 A ，和一个发送端 B
////2 ·接收端 A 在 9999 端口等待接收数据（receive）
////3 ·发送端 B 向接收端 A 发送数据 "hello ，明天吃火锅“
////4 ·接收端 A 接收到发送端 B 发送的数据，回复''好的，明天见"，再退出
////5 ·发送端接收 回复的数据，再退出
public class UDPreceiver {
    public static void main(String[] args) throws IOException {
        //接收端等待接收
        DatagramSocket socket = new DatagramSocket(9999);
        System.out.println("等待接收数据，，");

        //接收
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        socket.receive(packet);

        //拆包输出
        int length = packet.getLength();
        byte[] data = packet.getData();
        String str = new String(data, 0, length);
        System.out.println(str);

        //打包发送
        byte[] buf1 = "好的，明天见".getBytes();
        DatagramPacket packet1 = new DatagramPacket(buf1, buf1.length, InetAddress.getLocalHost(), 9998);
        //DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByname(xxxxxxxxx), 9999);
        //更符合实际开发
        socket.send(packet1);

        //关闭
        socket.close();
    }
}
