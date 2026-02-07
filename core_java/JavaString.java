public class JavaString {
    void basic() {
        System.out.println("String Basic:");
         String txt = "ABsdfsdfsdfljwlerwel34958fdljf9fw";
        System.out.println("The length of the txt string is : " + txt.length());

        txt = "Hello World";
        System.out.println(txt.toUpperCase());
        System.out.println(txt.toLowerCase());

        txt = "Please locate where 'locate' occurse!";
        System.out.println(txt.indexOf("locate"));

        System.out.println(txt.charAt(0));
    }

    void compareStrings(String str1, String str2) {
        System.out.println("Comparing Strings:");
        System.out.println(str1.equals(str2));
    }

    void removeWhitespace(String str) {
        System.out.println("Removing Whitespaces:");
        System.out.println("Before: " + str);
        System.out.println("After: " + str.trim());
    }

    void concateString(String name, int age) {
        System.out.println("Concatenations:");
        System.out.println("My name is " + name + " and I am " + age + " years old.");
    }

    void printStringWithSpecialCharacter() {
        System.out.println("Java Special Character:");
        
        String txt1 = "We are the so-called \"Vikings\" from the north";
        String txt2 = "It\'s alright";
        String txt3 = "The characte \\ is called backslash.";

        System.out.println(txt1);
        System.out.println(txt2);
        System.out.println(txt3);
    }
    public static void main(String[] args) {
       JavaString javaString = new JavaString();

       javaString.basic();;
       javaString.compareStrings("Hello", "Hello");
       javaString.concateString("Yeasin", 26);
       javaString.removeWhitespace("       Hi, this is test ...           ");
       javaString.printStringWithSpecialCharacter();
    }
}
