public class Recursion {
    public static int sum(int n) {
        if(n == 0) return n;
        return n + sum(n - 1);
    }

    public static int fact(int n) {
        if(n == 0) return 1;
        return n * fact(n - 1);
    }
    public static void main(String[] args) {
        System.out.println("sum of all numbers from 1 to n: " + sum(10));
        System.out.println("factorial of is : " + fact(10));
    }
}
