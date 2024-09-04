package reflection;


//获取Class对象
public class getclass {
    public static void main(String[] args) throws ClassNotFoundException {

        //1 class.forname
        String filepath = "reflection.car";
        Class<?> aClass = Class.forName(filepath);
        System.out.println(aClass);

        //2.类名.class,应用于参数传递
        Class filepath2 = car.class;
        System.out.println(filepath2);

        //3, 对象.getclass,应用场景：有对象实列
        car car = new car();
        Class filepath3 = car.getClass();
        System.out.println(filepath3);

        //4  通过类加载器获取Class对象
        //类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        //得到class对象
        Class<?> filepath4 = classLoader.loadClass(filepath);
        System.out.println(filepath4);

        //基本数据类型得到class对象
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);
        Class<Character> characterClass = char.class;
        System.out.println(characterClass);

        // 6 ·基本数据类型对应的包装类，可以通过· TYPE 得到 class 类对象
        Class<Integer> type1 = Integer.TYPE;
        Class<Character> type2 = Character.TYPE;
        System.out.println(type1);
        System.out.println(type2);


    }
}
