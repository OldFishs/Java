package test;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    public static void main(String[] args){
        List<Object> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<a> list3= new ArrayList<>();
        List<b> list4 = new ArrayList<>();
        List<c> list5 = new ArrayList<>();

    }
}


class a{}
class b extends a{}
class c extends a{}
 
class d <T>{
    public  void aa(T c){
    }
}