import java.util.Scanner;

class Practice {
    int AreaOfRectangle() {
        System.out.println("======Area of Rectangle======");
        Scanner scan = new Scanner(System.in);
        int length, width, area;

        System.out.print("Length: ");
        length = scan.nextInt();

        System.out.print("Width: ");
        width = scan.nextInt();
        area = length * width;
        return area;
    }
}

public class JavaSyntax {

    public static void main(JavaString[] args) {

        Practice practice = new Practice();

        System.out.println(practice.AreaOfRectangle());
    }
}
