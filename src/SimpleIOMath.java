import java.sql.SQLOutput;
import java.util.Scanner;

/** SimpleIOMath.java is my second lab. It will ask the user to input numerical data and will perform various calculations with the inputted numbers.
 * @version 09/22/2020
 * @author 22tanaka
 */

public class SimpleIOMath {
    /**
     * Sources:
     * For loops: https://www.w3schools.com/java/java_for_loop.asp
     */

    private String name;
    private int age;
    private int favNumber;
    private int nextPrime;

    /**
     * Asks User information: name, age, and favorite number.
     */
    public void promptUser() {

        System.out.println("* Sit yourself down, take a seat *\n" +
                "* All you gotta do is repeat after me *");

        Scanner q = new Scanner(System.in);

        System.out.print("Question 1: What is your name? ");
        name = q.nextLine();

        System.out.print("Question 2: How old are you? ");
        age = q.nextInt();

        System.out.print("Question 3: What is your favorite number? ");
        favNumber = q.nextInt();

        System.out.println("I'm gonna teach you how to sing it out\n" +
                "Come on, come on, come on\n" +
                "Let me tell you what it's all about\n" +
                "Reading, writing, arithmetic\n" +
                "Are the branches of the learning tree");


    }
    /**
     *  Prints the user-inputted info and calculations based off that info.
     */
    public void printInfo() {

        int nextAge = age + 1;
        
        for (int n = 2; n <= age; n++) {
            if (age % n == 0) {
                nextPrime = n;
                break;
            }
        }

        int favNumsq = (int) Math.pow(favNumber, 2);

        System.out.println("Your name is: " + name +
                        "\nYour age is: " + age +
                        "\nAt your next birthday, you will turn " + nextAge + "." +
                        "\nThe first prime factor of " + age + " is: " + nextPrime +
                        "\nYour favorite number is: " + favNumber +
                        "\nYour favorite number squared is: " + favNumsq);
    }

    /**
     * Main method (entry point) for SimpleIOMath.java
     * @param args
     */
    public static void main(String[] args) {
        /* main method - entry point of SimpleIOMath.java */

        SimpleIOMath hi = new SimpleIOMath();
        hi.promptUser();
        hi.printInfo();

        System.out.println("* end of program *");
        System.exit(0);
    }
}
