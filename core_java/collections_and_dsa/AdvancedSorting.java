import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Car {
    public String brand;
    public String model;
    public int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}
//Creat a comparator
class SortByYear implements Comparator<Car> {
    public int compare(Car a, Car b) {
        if(a.year < b.year) return -1;
        if(a.year > b.year) return 1;
        return 0;
    }
}

public class AdvancedSorting {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<Car>();

        cars.add(new Car("BMW", "X5", 1999));
        cars.add(new Car("Honda", "Accord", 2006));
        cars.add(new Car("Ford", "Mustang", 1970));

        Comparator<Car> cmp = new SortByYear();

        Collections.sort(cars, cmp);

        for(Car c : cars) {
            System.out.println(c.brand + " " + c.model + " " + c.year);
        }
    }
}
