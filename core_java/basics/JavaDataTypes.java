public class JavaDataTypes {

    int items = 50;
    float costPerItem = 9.99f;
    float totalCost = items * costPerItem;
    char currentcy = '$';

    void differentDataTypes() {
        System.out.println("Number of items: " + items);
        System.out.println("Cost per item: " + costPerItem + currentcy);
        System.out.println("Total cost: " + totalCost + currentcy);
    }
    public static void main(JavaString[] args) {
        JavaDataTypes javaDataTypes = new JavaDataTypes();

        javaDataTypes.differentDataTypes();
    }
}
