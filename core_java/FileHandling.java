import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        try {
            File file = new File("myfile.txt");
            
            if(file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
            else {
                System.out.println("File already exists");
            }
        }catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //true = append mode
        try(FileWriter fileWriter = new FileWriter("myfile.txt", true)) {
            fileWriter.append("Appended Text!\n");
            System.out.println("Successfully appended to the file");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("File Texts: ");

        try(Scanner scan = new Scanner(new File("myfile.txt"))) {
            while(scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        }catch(FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
