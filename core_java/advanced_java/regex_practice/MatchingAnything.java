/* the dot(.) matches anything except for a new line
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingAnything {
    public static void main(String args[]) {
        String text1 = "123.456.abc.def"; // true
        String text2 = "1123.456.abc.def"; // false

        Pattern pattern = Pattern.compile("^.{3}\\..{3}\\..{3}\\..{3}$");
        Matcher matcher = pattern.matcher(text1);

        System.out.println(matcher.matches());
        //System.out.println(matcher.find());
    }
}
