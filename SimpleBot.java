package bot;

import java.util.Scanner;

public class SimpleBot {
    //Create a scanner object for reading input from the user
    final static Scanner scanner = new Scanner(System.in); // Do not change this line

    public static void main(String[] args) {
        greet("AI Allen", "2024"); // change it as you need
        remindName();
        guessAge();
        count();
        test();

    }
    //Method to greet the user
    static void greet(String assistantName, String birthYear) {
        System.out.println("Hello! My name is " + assistantName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
    }
    //Method to remind the bot of the user's name
    static void remindName() {
        String name = scanner.nextLine();
        System.out.println("What a great name you have, " + name + "!");
    }

    //Method to guess the users age using the remainders method
    static void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int rem3 = scanner.nextInt();
        int rem5 = scanner.nextInt();
        int rem7 = scanner.nextInt();
        int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }

    //Method to count from 0 to the number provided by the user
    static void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int num = scanner.nextInt();
        for (int i = 0; i <= num; i++) {
            System.out.printf("%d!\n", i);
        }
    }

    //Method to test the user's programming knowledge
    static void test() {
        System.out.println("Let's test your programming knowledge.");
        // write your code here
        System.out.println("""
                Why do we use methods?
                1. To repeat a statement multiple times.
                2. To decompose a program into several small subroutines.
                3. To determine the execution time of a program.
                4. To interrupt the execution of a program.""");
        int answer=2;
        int userAnswer=scanner.nextInt();

        while(userAnswer!=answer){
            System.out.println("Please try again");
            userAnswer=scanner.nextInt();
        }

        if (userAnswer>=4){
            System.out.println("Please only choose number 1-4");
        }

        if (userAnswer==answer){
            end();
        }



    }

    //Method to end the conversation
    static void end() {
        System.out.println("Congratulations, have a nice day!"); // Do not change this text
    }
}
