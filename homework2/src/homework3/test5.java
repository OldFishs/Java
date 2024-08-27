package homework3;


import java.io.*;

//反序列化演示
public class test5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String filepath = "d:\\data.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));

        //读取：反序列化需与序列化顺序一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        //编译类型object，运行类型dog
        Object dog1 = ois.readObject();
        System.out.println(dog1);
        //使用dog方法，向下转型
        //需将dog类定义拷贝到可以引用的位置

        dog dog2 = (dog)dog1;
        System.out.println(dog2.getName());

        ois.close();


    }
}


class dog implements Serializable {
    private int age;
    private String name;

    //序列号，提高兼容性
    private static final long serialVersionUID = 1L;

    public dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
