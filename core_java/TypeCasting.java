public class TypeCasting {
    public static void main(JavaString[] args) {
        int maxScore = 500;
        int userScore = 423;

        /* Calculate the percentage of the user's score in relation to the maximum available score.
Convert userScore to double to make sure that the division is accurate */
        double percentage = (double)userScore / maxScore * 100.0;
        System.out.println("User's percentage is " + percentage);
    }
}
