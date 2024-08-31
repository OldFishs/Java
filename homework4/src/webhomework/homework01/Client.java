package webhomework.homework01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//（ 1 ）使用字符流的方式，编写一个客户端程序和服务器端程序，
//（ 2 ）客户端发送 "name", 服务器端接收到后，返回"我是nova ",nova 是你自己的名字·
//（ 3 ）客户端发送 "hobby", 服务器端接收到后，返回"编写java程序"
//（ 4 ）不是这两个问题，回复"你说啥呢"

@SuppressWarnings({"all"})
public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("说话？？！！！：");
        String s = scanner.next();

        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //name/hobby/cnmd
        bw1.write(s);
        bw1.flush();
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String name = br.readLine();
        System.out.println(name);

        bw1.close();
        br.close();
        socket.close();

    }
}
