import java.util.Scanner;
/*
Work on project. Stage 3/5: Tickets

Objectives
Read two positive integer numbers that represent the number of rows and seats in each row and print the seating arrangement like in the first stage. Then, read two integer numbers from the input: a row number and a seat number in that row. These numbers represent the coordinates of the seat according to which the program should print the ticket price. The ticket price is determined by the same rules as the previous stage:

If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the rest 5 rows.
After that, the program should print out all the seats in the screen room as shown in the example and mark the chosen seat by the B symbol. Finally, it should print the ticket price and stop. Note that in this project, the number of rows and seats won't be greater than 9.

Examples
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Example 1

Enter the number of rows:
> 7
Enter the number of seats in each row:
> 8

Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S S S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S

Enter a row number:
> 3
Enter a seat number in that row:
> 6

Ticket price: $10

Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S B S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S
Example 2

Enter the number of rows:
> 8
Enter the number of seats in each row:
> 9

Cinema:
  1 2 3 4 5 6 7 8 9
1 S S S S S S S S S
2 S S S S S S S S S
3 S S S S S S S S S
4 S S S S S S S S S
5 S S S S S S S S S
6 S S S S S S S S S
7 S S S S S S S S S
8 S S S S S S S S S

Enter a row number:
> 6
Enter a seat number in that row:
> 5

Ticket price: $8

Cinema:
  1 2 3 4 5 6 7 8 9
1 S S S S S S S S S
2 S S S S S S S S S
3 S S S S S S S S S
4 S S S S S S S S S
5 S S S S S S S S S
6 S S S S B S S S S
7 S S S S S S S S S
8 S S S S S S S S S
 */

public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seats = sc.nextInt();

        char[][] cinemaSeats = printSeats(rows, seats);

        System.out.println("Enter a row number: ");
        int row = sc.nextInt();
        System.out.println("Enter a seat number in that row: ");
        int seat = sc.nextInt();

        System.out.println(checkTicketPrice(rows, seats, row));

        cinemaSeats[row - 1][seat - 1] = 'B';

        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i < seats + 1; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats; j++) {
                System.out.print(" " + cinemaSeats[i][j]);
            }
            System.out.println("");
        }
        //System.out.println("Total income:");
        //System.out.println("$" + calculateProfit(rows, seats));
    }

    public static char[][] printSeats(int rows, int seats) {
        char[][] seat = new char[rows][seats];
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i < seats + 1; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats; j++) {
                seat[i][j] = 'S';
                System.out.print(" " + seat[i][j]);
            }
            System.out.println("");
        }
        return seat;
    }

    public static int calculateProfit(int rows, int seats) {
        return rows * seats < 60 ? (rows * seats) * 10 : isOdd(rows, seats);
    }

    public static String checkTicketPrice(int rows, int seats, int row) {
        return row >= (rows / 2 + 1) && rows * seats > 60 ? "Ticket price: $8" : "Ticket price: $10";
    }

    public static int isOdd(int rows, int seats) {
        return rows % 2 == 1 ? ((rows / 2 * seats) * 10 + (((rows / 2 + 1) * seats) * 8)) :
                (((rows / 2) * seats) * 10 + ((rows / 2) * seats) * 8);
    }
}

