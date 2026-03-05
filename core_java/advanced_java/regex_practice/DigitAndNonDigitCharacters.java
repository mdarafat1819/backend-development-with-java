import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitAndNonDigitCharacters {
    public static void main(String args[]) {
        String text1 = "06-11-2015"; //true
        String text2 = "06-11-015"; //false
        String text3 = "10a10.2015452254"; //true

       Pattern pattern = Pattern.compile("\\d{2}\\D\\d{2}\\D\\d{4}");
       Matcher matcher = pattern.matcher(text1);

        System.out.println(matcher.find());
    }
}
