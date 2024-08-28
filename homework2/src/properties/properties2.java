package properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class properties2 {
    public static void main(String[] args) throws IOException {
        //使用properties读取mysql
        //1.创建properties 对象
        Properties properties = new Properties();
        //2.加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //3.把kv显示在控制台
        properties.list(System.out);
        //4.根据key获取相应值
        String ip = properties.getProperty("ip");
        System.out.println(ip);

    }
}
