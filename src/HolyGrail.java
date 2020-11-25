import java.util.Scanner;

/**
 * HolyGrail.java is the first lab I will write it is a simple
 * UI program that talks to the user.
 * 09/15/2020
 * @author 22tanaka
 */

public class HolyGrail {
    public static void main(String[] args) {
        /* Java User Inputs (source): https://www.w3schools.com/java/java_user_input.asp
        * Exit: https://www.edureka.co/blog/system-exit-in-java/*/

        Scanner question = new Scanner(System.in);

        System.out.println("* A chat with the bridge keeper *\n" +
                "Who would cross the Bridge of Death must answer me these" +
                "questions three, ere the other side he see.");

        System.out.print("Question 1: What is your name? ");
        String name = question.nextLine();

        System.out.print("Question 2: What is your quest? ");
        String quest = question.nextLine();

        System.out.print("Question 3: What is your favorite color? ");
        String color = question.nextLine();

        System.out.println("King Arthur says, \"You have to know these things when you're a\n" +
                "king, you know.\"\n" +
                "Your name is: " + name + "\n" +
                "Your quest is: " + quest + "\n" +
                "Your favorite color is: " + color);

        System.exit(0);
    }
}
