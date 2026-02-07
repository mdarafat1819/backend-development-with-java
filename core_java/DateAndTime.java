import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

    public static void main(String[] args){
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("Before formatting: " + dateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY  HH:mm:ss");
        
        String formattedDateTime = formatter.format(dateTime);

        System.out.println("After formatting: " + formattedDateTime);
    }
    
}
