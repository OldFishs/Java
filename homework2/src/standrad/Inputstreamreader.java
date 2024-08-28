package standrad;


import java.io.*;

//转换流   Inputstreamreader解决中文乱码问题
//将字节流fileinputstream转为字符流 inputstreamreader，指定编码gbk/utf-8

public class Inputstreamreader {

    public static void main(String[] args) throws IOException {
        String filepath = "d:\\data.txt";

        //1.new FileInputStream(filepath)转成InputStreamReader
        //2.指定编码gbk
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filepath),"gbk");
        //3.InputStreamreader 传入 bufferReader
        BufferedReader br = new BufferedReader(isr);

        //23和为一步
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"gbk"));
        //4.读取
        String s = br.readLine();
        System.out.println(s);
        //5.关闭外层流
        br.close();
    }
}
