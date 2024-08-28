package homework4;

import java.io.*;

//要求：使用BUfferReader读取一个文本文件，为每行加上行号，再连同内容一同输出到屏幕上
public class homework02 {
    public static void main(String[] args) throws IOException {
        String filepath = "d:\\hello.txt";
        BufferedReader br = null;

        //转换流，避免乱码
        br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"gbk"));
        String line = " ";
        for(int i = 0;(line = br.readLine()) != null; i++) {
            System.out.println("(" + i + ")" +line);

        }

        br.close();
    }
}
