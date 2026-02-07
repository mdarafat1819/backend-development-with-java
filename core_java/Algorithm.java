import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algorithm {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<String>();

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        Collections.sort(cars);
        System.out.println(cars);

        // Collections.sort(cars, Collections.reverseOrder());
        // System.out.println(cars);

        int index = Collections.binarySearch(cars, "Ford");
        System.out.println("Index: " + index);
    }
}
