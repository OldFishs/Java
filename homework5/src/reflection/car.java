package reflection;

public class car {
    public String brand = "baoma";
    public  String price = "909090";
    public String color = "red";

    @Override
    public String toString() {
        return "car{" +
                "brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
