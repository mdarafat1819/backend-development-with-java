import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataStructure {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<String>();

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");//Duplicate
        cars.add("Mazda"); 

        System.out.println("ArrayList: ");
        System.out.println(cars);

        System.out.println("Set Data Structure: ");
        Set<String> carSet = new HashSet<String>();
        
        carSet.add("Volvo");
        carSet.add("BMW");
        carSet.add("Ford");
        carSet.add("BMW");//Duplicate
        carSet.add("Mazda");
        System.out.println(carSet);

        System.out.println("Map Data Structure: ");
        Map<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

       for(String capital : capitalCities.values()) {
        System.out.println(capital);
       }
    }
}
