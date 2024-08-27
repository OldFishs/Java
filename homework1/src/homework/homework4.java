package homework;

import java.util.HashMap;
import java.util.HashSet;

public class homework4 {
    public static void main(String[] args) {
        HashSet<student> set = new HashSet<student>();
        set.add(new student("javak",123));
        set.add(new student("reck",1193));
        set.add(new student("tom",11273));

        for(student s : set){
             System.out.println(s);
        }

        HashMap<student,student> hashMap = new HashMap<student, student>(   );


    }
}

class student{
    private String name;
    private int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}