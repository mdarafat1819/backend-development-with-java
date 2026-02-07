import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Car implements Comparable<Object> {
    public String brand;
    public String model;
    public int year;

    public Car(String b, String m, int y) {
        brand = b;
        model = m;
        year = y;
    }

    @Override
    public int compareTo(Object obj) {
        if(year < ((Car)obj).year) return -1;
        if(year > ((Car)obj).year) return 1;
        return 0;
    }
}


public class AdvancedSorting2 {
    public static void main(String[] args){
        List<Car>cars = new ArrayList<Car>();

        cars.add(new Car("BMW", "X5", 1999));
        cars.add(new Car("Honda", "Accord", 2006));
        cars.add(new Car("Ford", "Mustang", 1970));

        Collections.sort(cars);

        for(Car car : cars) {
            System.out.println(car.brand + " " + car.model + " " + car.year);
        }
        
    }
}
