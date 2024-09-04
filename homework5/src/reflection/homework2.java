package reflection;

//1 ·利用 Class 类的 forName 方法得到 FiIe 类的 class 对象
// 2 ·在控制台打印 file 类的所有构造器
// 3 ·通过 newlnstance 的方法创建 File 对象，并创建 d:\mynew.txt 文件

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class homework2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructor = aClass.getDeclaredConstructors();

        for (Constructor<?> constructor : declaredConstructor) {
            System.out.println(constructor);
        }
        Constructor<?> declaredConstructor1 = aClass.getDeclaredConstructor(String.class);
        String filepath = "d:\\mynew.txt";
        Object o = declaredConstructor1.newInstance(filepath);

        Method createNewFile = aClass.getMethod("createNewFile");
        createNewFile.invoke(o);
        //创建file对象

        System.out.println(o.getClass());


    }
}
