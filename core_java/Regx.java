import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regx {
    public static void main(JavaString[] args) {
        Pattern pattern = Pattern.compile("W3schools", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Visiti W3Schools!");

        if(matcher.find()) System.out.println("Match found");
        else System.out.println("Match not found");
        
    }
}
