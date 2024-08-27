package homework;

import java.util.ArrayList;
import java.util.Comparator;

public class homework5 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("w",44,new Mydate(12,12,12)));
        list.add(new Employee("q",35,new Mydate(15,15,15)));
        list.add(new Employee("w",11,new Mydate(18,1,1)));
        for(Employee e : list){
            System.out.println(e);
        }
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if(!(e1 instanceof Employee && e2 instanceof Employee)){
                    return 0;
                }
                int i = e1.getName().compareTo(e2.getName());
                if(i != 0){
                    return i;
                }
                return e1.getDate().compareTo(e2.getDate());

            }
        });
        System.out.println(list);

    }
}

class Employee{
    private String name;
    private int salary;
    private Mydate date;

    public Employee(String name, int salary, Mydate date) {
        this.name = name;
        this.salary = salary;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Mydate getDate() {
        return date;
    }

    public void setDate(Mydate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", date=" + date +
                '}';
    }
}

class Mydate implements Comparable<Mydate>{
    private int year;
    private int month;
    private int day;

    public Mydate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Mydate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Mydate o) {
        int yearm = year - o.getYear();
        if(year != 0){
            return year;
        }
        int  monthm = month - o.getMonth();
        if(month != 0){
            return month;
        }
        return day - o.getDay();
    }
}
