package homework3;

import java.io.*;

public class test2 {

    //字符流拷贝文件
    //bufferedreader bufferedwriter 按照字符操作，不能读取二进制文件 可能造成文件损坏（声音 视频 doc pdf

    public static void main(String[] args){
        String srcfilepath = "d:\\note.txt";
        String destfilepath = "d:\\note2.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(srcfilepath));
            bw = new BufferedWriter(new FileWriter(destfilepath));
            while((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
                System.out.println("拷贝结束，，，，");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null){
                    br.close();
                }
                if(bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
