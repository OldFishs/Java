package reflection;

import java.io.Serializable;

//哪些类型有class对象
public class allTypeClass {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;//外部类
        System.out.println(stringClass);
        Class<Serializable> serializableClass = Serializable.class;//接口
        System.out.println(serializableClass);
        Class<float[][]> aClass = float[][].class;//二维数组
        System.out.println(aClass);
        //枚举
        Class<Thread.State> stateClass = Thread.State.class;
        System.out.println(stateClass);
        Class<Long> longClass = long.class;
        System.out.println(longClass);
        Class<Void> voidClass = void.class;
        Class<Class> classClass = Class.class;
        System.out.println(classClass);


    }
}
