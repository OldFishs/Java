package homework3;

import java.io.*;

public class test3 {

    //字节流拷贝文件
    //bufferedoutputstream bufferedinputstream 使用，二进制文件拷贝 也可操作文本文件
    public static void main(String[] args){
        String bfilepath = "d:\\photo.jpg";
        String efilepath = "d:\\photo2.jpg";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        int line;
        byte b[] = new byte[1024];

        try {
            bis = new BufferedInputStream(new FileInputStream(bfilepath));
            bos = new BufferedOutputStream(new FileOutputStream(efilepath));
            while((line = bis.read(b)) != -1){
                bos.write(b, 0, line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bos.close();
                bis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
