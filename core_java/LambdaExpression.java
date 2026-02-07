import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaExpression {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        nums.add(5);
        nums.add(9);
        nums.add(8);
        nums.add(1);

        nums.forEach((n)->{System.out.println(n);});

        //Consumer Class
        Consumer<Integer> method = (n)->{
            System.out.println(n);
        };

        nums.forEach(method);
    }
}
