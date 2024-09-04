package reflection;

import java.lang.reflect.Field;

public class class01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classpath = "reflection.car";
        Class<?> cls =  Class.forName(classpath);

        //cls
        System.out.println(cls);//哪个类的class对象
        System.out.println(cls.getClass());//cls运行类型

        //包名
        System.out.println(cls.getPackage());
        System.out.println(cls.getPackage().getName());

        //全类名
        System.out.println(cls.getName());

        //通过cls创建对象实例
        car car = (car)cls.newInstance();
        System.out.println(car);

        //获取属性brand
        Field baoma = cls.getField("brand");
        System.out.println(baoma);
        System.out.println(baoma.get(car));

        //通过反射给属性赋值
        baoma.set(car,"benchi");
        System.out.println(baoma.get(car));

        //得到所有属性字段
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f);
            System.out.println(f.getName());
        }
    }
}
