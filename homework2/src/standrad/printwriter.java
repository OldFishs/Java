package standrad;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//演示字符打印输出流 printwriter
public class printwriter {
    public static void main(String[] args) throws IOException {
        //PrintWriter pw = new PrintWriter(System.out);
        PrintWriter pw = new PrintWriter(new FileWriter("d:\\test2.txt"));
        pw.print("你好，北京");
        pw.close();
    }
}
