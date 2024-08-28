package homework1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test3 {
    public static void main(String[] args){
        String s = "d:\\story.txt";
        FileReader fr = null;
        int readlen =0;
        char buf[] = new char[8];

        try {
            fr = new FileReader(s);
            while((readlen = fr.read(buf)) != -1){
                System.out.print(new String(buf,0,readlen));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
