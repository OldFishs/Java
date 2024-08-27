package homework;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class homework2 {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        car car1 =new car("h",1111111);
        car car2 =new car("f",2222222);
        arr.add(car1);
        for(int i = 0;i<5;i++){
            arr.addAll(arr);
        }
        for(Object o : arr){
            System.out.println(o);
        }

    }
}

class car{
    private String name;
    private double price;

    public car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "car{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
