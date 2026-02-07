public class Array {
    public static void main(String[] args) {
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        cars[0] = "Opel";

        System.out.println(cars[0]);
        System.out.println("Length of cars: " + cars.length);

        int[] nums = new int[4];
        nums[0] = 1;
        nums[1] = 3;
        nums[2] = 4;
        nums[3] = 5;

        System.out.println("Nums: ");
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println("Cars: ");
        for(String car : cars) {
            System.out.print(car + " ");
        }
    }
}
