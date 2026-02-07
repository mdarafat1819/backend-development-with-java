public class Main {
    public static void main() {
        System.out.println("Hello World");
        
        boolean a, b, c;
        a = b = c = false;
        b = true;
        c = true;

        if(a || b && c) 
            System.out.println("True");
        else System.out.println("False");

        boolean test = a || b && c;
        System.out.println(test);
    }
}