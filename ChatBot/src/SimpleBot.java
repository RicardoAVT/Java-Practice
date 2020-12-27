import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleBot {

        private static Scanner scanner = new Scanner(System.in);

        public static void greet(String assistantName, String birthYear) {
            System.out.println("Hello! My name is " + assistantName + ".");
            System.out.println("I was created in " + birthYear + ".");
            System.out.println("Please, remind me your name.");
        }

        public static void remindName() {
            String name = scanner.nextLine();
            System.out.println("What a great name you have, " + name + "!");
        }

        public static void guessAge() {
            System.out.println("Let me guess your age.");
            System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
            int rem3 = scanner.nextInt();
            int rem5 = scanner.nextInt();
            int rem7 = scanner.nextInt();
            int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
            System.out.println("Your age is " + age + "; that's a good time to start programming!");
        }

        public static void count() {
            System.out.println("Now I will prove to you that I can count to any number you want.");
            int num = scanner.nextInt();
            for (int i = 0; i <= num; i++) {
                System.out.printf("%d!\n", i);
            }
        }

        public static void test() {

            Map<Integer, String> answers = new HashMap<Integer, String>();

            System.out.println("Let's test your programming knowledge.");

            answers.put(1, "To repeat a statement multiple times.");
            answers.put(2, "To decompose a program into several small subroutines.");
            answers.put(3, "To determine the execution time of a program.");
            answers.put(4, "To interrupt the execution of a program.");

            for (Integer key : answers.keySet()) {
                String value = answers.get(key).toString();
                System.out.println(key + "." + " " + value);
            }

            int answer = scanner.nextInt();
            while (answer != 2) {
                System.out.println("Please, try again.");
                answer = scanner.nextInt();
            }
        }

        public static void end() {
            System.out.println("Congratulations, have a nice day!");
        }
    }


