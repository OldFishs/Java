package reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//练习 1 ·定义 PrivateTest 类，有私有 name 属性，并且属性值为 hellokitty
// 2 ·提供 getName 的公有方法
// 3 ·创建 PrivateTest 的类，利用 Class 类得到私有的 name 属性，修改私有的 name 属性值，调用 getName() 的方法打印 name 属性值
public class homework1 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //拿到class对象
        Class<privatetest> privatetestClass = privatetest.class;
        //创建对象实例
        privatetest privatetest = privatetestClass.newInstance();
        //得到name属性
        Field name = privatetestClass.getDeclaredField("name");
        //爆破
        name.setAccessible(true);
        //修改
        name.set(privatetest,"66666");
        //得到getname对象
        Method getname = privatetestClass.getMethod("getName");
        //调用
        Object invoke = getname.invoke(privatetest);
        System.out.println(invoke);


    }
}

class privatetest{
    private String name = "hellokitty";

    public String getName() {
        return name;

    }
}
