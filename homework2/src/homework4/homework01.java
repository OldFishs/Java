package homework4;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//(1)在判断 d 盘下是否有文件夹 mytemp ，如果没有就创建 mytemp
//(2)在 d:\\mytemp 目录下，创建文件 hello.txt
//(3)如果 hello.txt 已经存在，提示该文件已经存在，就不要再重复创建
//(4)在hello文件中写入hello,world
public class homework01 {
    public static void main(String[] args) throws IOException {
        String filepath = "d:\\mytemp.txt";
        File file = new File(filepath);

        if(!file.exists()){
            file.mkdirs();
            System.out.println("创建成功");
        }else{
            System.out.println("File already exists");
        }

        String filepath2 = filepath + "\\hello.txt";
        File file2 = new File(filepath2);

        if(!new File(filepath2).exists()){
            file2.createNewFile();
            System.out.println("创建成功");
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath2));
            bw.write("hello,world");
            bw.close();
        }else{
            System.out.println("File already exists");
        }
    }
}
