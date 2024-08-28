package homework4;


import java.io.*;
import java.util.Properties;

//(1)要编写一个dog.properties
//name = tom
//age = 5
//color = red
//(2)编Dog类 (name,age,color) 创建一个dog对象，读取 dog.properties用相应的内容完成属性初始化，并输出
//(3)将创建的 Dog 对象，序列化到文件  d:\\dog.data 文件
public class homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filepath = "src\\homework4\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filepath));
        properties.list(System.out);

        String name = properties.getProperty("name");
        //int age = (int)properties.get("age")报错！
        int age = Integer.parseInt((String) properties.get("age"));
        String color = properties.getProperty("color");

        Dog dog = new Dog(name, age, color);
        System.out.println(dog);

        //序列化
        String filepath2 = "d:\\dog.dat";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath2));
        out.writeObject(dog);

        //反序列化
        /*
        BufferedReader isr = new BufferedReader(new InputStreamReader(new FileInputStream(filepath2),"gbk"));

        while(isr.readLine() != null){
            System.out.println(isr.readLine());
        }
        会失败，依然乱码
         */
        out.close();

        //反序列化
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filepath2));
        Dog dog2 = (Dog)in.readObject();
        System.out.println("------反序列化------");
        System.out.println(dog2);
        in.close();
    }
}

class Dog implements Serializable{
    private String name;
    private int age;
    private String color;
    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
