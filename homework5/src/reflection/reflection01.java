package reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class reflection01 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfilepath = properties.get("classfilepath").toString();
        String classname = properties.get("classname").toString();
        System.out.println(classfilepath);
    }
}
