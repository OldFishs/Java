package properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class properties3 {
    public static void main(String[] args) throws IOException {
        //创建配置文件，修改配置文件内容
        Properties prop = new Properties();

        //创建
        //1.没key创建
        //2.有key修改
        //properties父类为hashtable
        prop.setProperty("charset", "utf8");
        prop.setProperty("user", "汤姆");//保存时为中文unicode编码
        prop.setProperty("pwd", "abc111");

        //将k-v存储在文件中
        prop.store(new FileOutputStream("src\\mysql2.properties"),null);
        System.out.println("保存配置文件成功。。。");

    }
}
