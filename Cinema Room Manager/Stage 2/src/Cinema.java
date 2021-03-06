import java.util.Scanner;
/*
Work on project. Stage 2/5: Sold!

    Objectives
    In this stage, you need to read two positive integer numbers from the input: the number of rows and the number of seats in each row. The ticket price is determined by the following rules:

    If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
    In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the rest 5 rows.
    Calculate the profit from the sold tickets depending on the number of seats and print the result as shown in the examples below. After that, your program should stop. Note that in this project, the number of rows and seats won't be greater than 9.

    Examples
    The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

    Example 1

    Enter the number of rows:
    > 4
    Enter the number of seats in each row:
    > 5
    Total income:
    $200
    Example 2

    Enter the number of rows:
    > 8
    Enter the number of seats in each row:
    > 9
    Total income:
    $648
    Example 3

    Enter the number of rows:
    > 9
    Enter the number of seats in each row:
    > 7
    Total income:
    $560

 */
public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seats = sc.nextInt();

        System.out.println("Total income:");
        System.out.println("$" + calculateProfit(rows, seats));


    }

    public static int calculateProfit(int rows, int seats) {
        return rows * seats < 60 ? (rows * seats) * 10 : isOdd(rows,seats);
    }

    public static int isOdd(int rows, int seats) {
        return rows % 2 == 1 ? ((rows / 2 * seats) * 10 + (((rows / 2 + 1) * seats) * 8)) :
                (((rows/2)*seats) * 10 + ((rows/2)*seats) * 8);
    }
}
