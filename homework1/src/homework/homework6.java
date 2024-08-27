package homework;

import org.junit.jupiter.api.Test;

import java.util.*;

public class homework6 {
    public static void main(String[] args) {

    }

    @Test
    public void mytest(){
        dao<user> dao = new dao<user>();
        dao.save("efasdfes   ",new user(1243,"xiaoming",167));
        System.out.println(dao);
    }
}

class user{
    private int id;
    private String name;
    private int age;

    public user(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "   user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class dao<T>{
    private Map<String,T> map = new HashMap<>();

    public void save(String id, T ent){
        map.put(id,ent);
    }

    public T get(String id){
        return map.get(id);
    }

    public List<T> list(){
        ArrayList<T> list = new ArrayList<>();
        Set<String> keys = map.keySet();
        for(String key : keys){
            list.add(map.get(key));
        }
        return list;
    }

    public void del(String id){
        map.remove(id);
    }

    @Override
    public String toString() {
        return "dao{" +
                "map=" + map +
                '}';
    }
}