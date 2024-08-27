package standrad;

import java.io.IOException;
import java.io.PrintStream;

//演示printstream 字节 打印输出流
public class printstream {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        /*
        //一般情况下输出位置标准输出 显示器
        public void print(String s) {
        if (s == null) {
            s = "null";
        }
        write(s);
        }
        */
        out.print("hello");
        //底层使用的是write,可以直接调用write打印
        out.write("北京，你好".getBytes());
        out.close();

        //public static void setOut(PrintStream out) {
        //        checkIO();
        //        setOut0(out);
        //    }
        System.setOut(new PrintStream("d:\\t1.txt"));
        System.out.println("北京，你好");


    }
}
