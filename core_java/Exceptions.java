public class Exceptions {

    static void checkAge(int age) {
        if(age < 18) {
            throw new ArithmeticException("Access denied");
        }
        else System.out.println("Access granted");
    }
    public static void main(JavaString[] args) {
        try{
            checkAge(17);
        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
