package homework1;

import java.io.*;

public class test2 {
    public static void main(String[] args) {

        String filepath = "d:\\photo.png";
        String filepath2 = "d:\\photo3.png";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(filepath);
            fos = new FileOutputStream(filepath2);
            byte buffer[] = new byte[1024];
            int readlen = 0;
            while((readlen = fis.read(buffer)) != -1){
                fos.write(buffer,0,readlen);
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(fis != null){
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
