package API;

import java.net.InetAddress;
import java.net.UnknownHostException;

//演示inetaddress的使用
public class api {
    public static void main(String[] args) throws UnknownHostException {
        //1.获取本机的Inetaddress对象
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip.getHostName() + " " + ip);

        //2.根据指定主机名，获取Inetaddress对象
        InetAddress pppp = InetAddress.getByName("pppp");
        System.out.println(pppp);

        //3.根据域名返回InetAddress对象，比如百度
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu);

        //4.通过InetAddress对象 获取对应地址
        String hostaddress = baidu.getHostAddress();
        System.out.println(hostaddress);

        //5.通过InetAddress对象 获取对应主机名/域名
        String hostname = baidu.getHostName();
        System.out.println(hostname);
    }
        //获取本机信息
        //通过域名获取远程服务器的IP
}
