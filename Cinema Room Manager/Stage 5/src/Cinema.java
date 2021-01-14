import java.util.Scanner;
/*
Work on project. Stage 5/5: Errors!

Objectives
Now your menu should look like this:

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
When the item Statistics is chosen, your program should print the following information:

The number of purchased tickets;
The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
Current income;
Total income that shows how much money the theatre will get if all the tickets are sold.
The rest of the menu items should work the same way as before, except the item Buy a ticket shouldn't allow a user to buy a ticket that has already been purchased.

If a user chooses an already taken seat, print That ticket has already been purchased! and ask them to enter different seat coordinates until they pick an available seat. Of course, you shouldn't allow coordinates that are out of bounds. If this happens, print Wrong input! and ask to enter different seat coordinates until the user picks an available seat.

Examples
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Enter the number of rows:
> 6
Enter the number of seats in each row:
> 6

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 0
Percentage: 0.00%
Current income: $0
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 2

Enter a row number:
> 1
Enter a seat number in that row:
> 1

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 1
Percentage: 2.78%
Current income: $10
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 2

Enter a row number:
> 1
Enter a seat number in that row:
> 1

That ticket has already been purchased!

Enter a row number:
> 10
Enter a seat number in that row:
> 20

Wrong input!

Enter a row number:
> 4
Enter a seat number in that row:
> 4

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 1

Cinema:
  1 2 3 4 5 6
1 B S S S S S
2 S S S S S S
3 S S S S S S
4 S S S B S S
5 S S S S S S
6 S S S S S S

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 2
Percentage: 5.56%
Current income: $20
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 0
 */
public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seats = sc.nextInt();

        showMenu(rows, seats);
    }

    public static char[][] cinemaSeats(int rows, int seats) {
        char[][] seat = new char[rows][seats];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                seat[i][j] = 'S';
            }
        }
        return seat;
    }

    public static void showMenu(int rows, int seats) {
        Scanner sc = new Scanner(System.in);
        char[][] reserved = cinemaSeats(rows, seats);
        int row;
        int seat;
        int ticketsPurchased = 0;
        int amountTicketsSold = 0;

        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");

        int option = sc.nextInt();

        while (option != 0) {
            switch (option) {
                case 1:
                    reserved = reservedSeats(reserved, rows, seats);
                    break;
                case 2:
                    System.out.println("Enter a row number: ");
                    row = sc.nextInt();
                    System.out.println("Enter a seat number in that row: ");
                    seat = sc.nextInt();

                    while (row < 0 || row > rows || seat > seats || seat < 0) {
                        System.out.println("Wrong input!");
                        System.out.println("Enter a row number: ");
                        row = sc.nextInt();
                        System.out.println("Enter a seat number in that row: ");
                        seat = sc.nextInt();
                    }

                    while (reserved[row - 1][seat - 1] == 'B') {
                        System.out.println("That ticket has already been purchased!");

                        System.out.println("Enter a row number: ");
                        row = sc.nextInt();
                        System.out.println("Enter a seat number in that row: ");
                        seat = sc.nextInt();
                    }
                    reserved[row - 1][seat - 1] = 'B';

                    System.out.println("Ticket price: $" + checkTicketPrice(rows, seats, row));
                    ticketsPurchased += 1;
                    amountTicketsSold += checkTicketPrice(rows, seats, row);
                    break;
                case 3:
                    System.out.println("Number of purchased tickets: " + ticketsPurchased);
                    System.out.println("Percentage: " + String.format("%.2f", ((float) ticketsPurchased / (rows * seats) * 100)) + "%");
                    System.out.println("Current income: $" + amountTicketsSold);
                    System.out.println("Total income: $" + calculateProfit(rows, seats));
                case 0:
                    break;
            }
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            option = sc.nextInt();
        }
    }

    public static char[][] reservedSeats(char[][] cinemaSeats, int rows, int seats) {

        char[][] reserved;

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
        reserved = cinemaSeats;
        return reserved;
    }

    public static int calculateProfit(int rows, int seats) {
        return rows * seats < 60 ? (rows * seats) * 10 : isOdd(rows, seats);
    }

    public static int isOdd(int rows, int seats) {
        return rows % 2 == 1 ? ((rows / 2 * seats) * 10 + (((rows / 2 + 1) * seats) * 8)) :
                (((rows / 2) * seats) * 10 + ((rows / 2) * seats) * 8);
    }

    public static int checkTicketPrice(int rows, int seats, int row) {
        return row >= (rows / 2 + 1) && rows * seats > 60 ? 8 : 10;
    }
}