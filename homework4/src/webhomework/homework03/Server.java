package webhomework.homework03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//（ 1 ）编写客户端程序和服务器端程序
// （ 2 ）客户端可以输入一个音乐文件名比如高山流水，服务端收到音乐名后给客户端返回这个音乐文件，
// 如果服务器没有这个文件，返回一个默认的音乐即可·
// （ 3 ）客户端收到文件后，保存到本地 d:\\
// （ 4 ）提示：该程序可以使用 StreamUtiIs.java
//
public class Server {
    public static void main(String[] args) throws Exception {
        //监听
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("等待连接，，，，");
        //等待客户端连接
        Socket socket = serverSocket.accept();
        //读取要下载的文件名
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        String dowmloadfile = "";
        //while读取考虑文件较大的情况
        while ((len = inputStream.read(buffer)) != -1) {
            dowmloadfile += new String(buffer, 0, len);
        }
        System.out.println("接收到客户端发送的文件：" + dowmloadfile);


        String returnfile = null;
        if(dowmloadfile.equals("高等数学")){
            returnfile = "src\\高等数学.txt";
        }else{
            returnfile = "src\\新英语.txt";
        }

        //创建输入流 读取对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(returnfile));
        byte[] buffer1 = StreamUtils.streamToByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(buffer1);
        bos.flush();
        socket.shutdownOutput();

        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出，，，，");
    }
}
