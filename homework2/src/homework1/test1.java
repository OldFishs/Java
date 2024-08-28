package homework1;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//io流相关
public class test1 {
    public static void main(String[] args){

    }
    @Test
    public void writefile(){
        FileOutputStream fos = null;
        String filepath = "d:\\a.txt";
        try {
            fos = new FileOutputStream(filepath,true);
            String s = "hello world";
            fos.write('k');
            fos.write(s.getBytes(),1,3);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

