package standrad;

import java.io.FileOutputStream;
import java.io.IOException;

//演示转换流  OutputStreamWriter用法
public class OutputStreamWriter {
    public static void main(String[] args) throws IOException {
        String filepath = "d:\\test.txt";
        java.io.OutputStreamWriter gbk = new java.io.OutputStreamWriter(new FileOutputStream(filepath),"gbk");
        gbk.write("wdnmd");
        gbk.close();
    }
}
