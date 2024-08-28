package properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class properties1 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
//        while((line = br.readLine()) != null){
//            System.out.println(line);
//        }

        while((line = br.readLine()) != null){
            String split[] = line.split("=");
            System.out.println(split[0] + "是：" + split[1]);
        }
        //传统方法不方便
        br.close();
    }
}
