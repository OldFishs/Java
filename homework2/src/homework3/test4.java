package homework3;

import java.io.*;


//序列化演示
public class test4 {

    //objectoutputstream 使用，完成数据序列化
    public static void main(String[] args) throws IOException {
        //序列化后 按照保存文件格式保存
        String filepath = "d:\\data.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));
        //序列化
        oos.writeInt(100);//int ->Integer
        oos.writeBoolean(true);//boolean ->Boolean
        oos.writeChar('a');//char ->Character
        oos.writeDouble(3.14);//...
        oos.writeUTF("北京欢迎您");//String
        oos.writeObject(new dog(12,"旺财"));

        oos.close();
        System.out.println("序列化完成");


    }
}


//序列化 类需实现serializable接口

