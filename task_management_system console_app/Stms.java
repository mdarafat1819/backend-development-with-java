public class Stms {
    public static void main(String[] args) {
       Home home = new Home();
       
        while(Home.isRun) {
            home.readCmd();
        }
    }
}