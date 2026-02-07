class Box<T> {
    T value; //T is a placeholder for any data type

    void set(T value) {
        this.value = value;
    }
    T get() {
        return value;
    }
}

public class GenericsClass {
    //Generic method
    public static<T> void print(T[] values) {
        for(T value : values) {
            System.out.println(value);
        }
    }
    public static void main(String[] args) {
        
        Box<String> box = new Box<>();

        box.set("Hello");
        System.out.println("Value: " + box.get());

        String[] names = {"Yeasin", "Arafat", "Hasnat", "Rahat"};
        Integer[] nums = {1, 2, 3, 4, 5, 6};

        System.out.print("Generic Method: ");
        print(names);
        print(nums);
    }
}
