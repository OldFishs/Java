package standrad;

import java.util.Scanner;

//标准输入输出流
public class test1 {
    public static void main(String[] args){
        //in
        //编译类型 Inputstream
        //运行类型 bufferedInputstream
        System.out.println(System.in.getClass());
        //out
        //编译类型  PrintStream
        //运行类型  PrintStream
        //表示标准输出 显示器
        System.out.println(System.out.getClass());
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入内容：");
        String next = sc.next();
        System.out.println(next);

    }
}
