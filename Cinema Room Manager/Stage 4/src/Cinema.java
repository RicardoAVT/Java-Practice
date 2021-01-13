import java.util.Scanner;
/*
Work on project. Stage 4/5: Menu, please!

Objectives
At the start, your program should read two positive integer numbers that represent the number of rows and seats in each row. Then, it should print a menu with the following three items:

Show the seats should print the current seating arrangement. The empty seats should be marked with an S symbol, and taken seats are marked with a B symbol.
Buy a ticket should read the seat coordinates from the input and print the ticket price like in the previous stage. After that, the chosen seat should be marked with a B when the item Show the seats is called.
Exit should stop the program.
Example
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Enter the number of rows:
> 7
Enter the number of seats in each row:
> 7

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S S S S
5 S S S S S S S
6 S S S S S S S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 2

Enter a row number:
> 4
Enter a seat number in that row:
> 5
Ticket price: $10

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S B S S
5 S S S S S S S
6 S S S S S S S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 2

Enter a row number:
> 6
Enter a seat number in that row:
> 6
Ticket price: $10

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S B S S
5 S S S S S S S
6 S S S S S B S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
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

        showMenu(rows,seats);
    }

    public static char[][] cinemaSeats(int rows,int seats){
        char[][] seat = new char[rows][seats];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                seat[i][j]='S';
            }
        }
        return seat;
    }

    public static String checkTicketPrice(int rows, int seats, int row){
        return row >= (rows / 2 + 1) && rows * seats > 60 ? "Ticket price: $8" : "Ticket price: $10";
    }

    public static void showMenu(int rows,int seats){
        Scanner sc = new Scanner(System.in);
        char[][] reserved = cinemaSeats(rows, seats);
        int row = 0;
        int seat = 0;

        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");

        int option = sc.nextInt();

        while (option != 0) {
            switch (option) {
                case 1:
                    reservedSeats(reserved, row, seat, rows, seats);
                    reserved = reservedSeats(reserved, row, seat, rows, seats);
                    break;
                case 2:
                    System.out.println("Enter a row number: ");
                    row = sc.nextInt();
                    System.out.println("Enter a seat number in that row: ");
                    seat = sc.nextInt();
                    System.out.println(checkTicketPrice(rows, seats, row));
                    break;
                case 0:
                    break;
            }
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            option = sc.nextInt();
        }
    }

    public static char[][] reservedSeats(char [][] cinemaSeats, int row,int seat, int rows,int seats){

        char[][] reserved;

        if (row != 0 && seat != 0){
            cinemaSeats[row - 1][seat - 1] = 'B';
        }

        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i < seats + 1; i++) {
            System.out.print(" " + i );
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
}