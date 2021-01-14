import java.util.Scanner;

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

    public static String checkTicketPrice(int rows, int seats, int row) {
        return row >= (rows / 2 + 1) && rows * seats > 60 ? "Ticket price: $8" : "Ticket price: $10";
    }

    public static void showMenu(int rows, int seats) {
        Scanner sc = new Scanner(System.in);
        char[][] reserved = cinemaSeats(rows, seats);
        int row;
        int seat;
        int ticketsPurchased = 0;



        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");

        int option = sc.nextInt();

        while (option != 0) {
            switch (option) {
                case 1:
                    reservedSeats(reserved, rows, seats);
                    reserved = reservedSeats(reserved, rows, seats);
                    break;
                case 2:
                    System.out.println("Enter a row number: ");
                    row = sc.nextInt();
                    System.out.println("Enter a seat number in that row: ");
                    seat = sc.nextInt();

                    while (row < 0 || seat > seats) {
                        System.out.println("Wrong input!");
                        System.out.println("Enter a row number: ");
                        row = sc.nextInt();
                        System.out.println("Enter a seat number in that row: ");
                        seat = sc.nextInt();
                    }

                    while (reserved[row - 1][seat - 1] == 'B'){
                        System.out.println("That ticket has already been purchased!");

                        System.out.println("Enter a row number: ");
                        row = sc.nextInt();
                        System.out.println("Enter a seat number in that row: ");
                        seat = sc.nextInt();
                    }
                    reserved[row - 1][seat - 1] = 'B';

                    System.out.println(checkTicketPrice(rows, seats, row));
                    ticketsPurchased += 1;
                    break;
                case 3:
                    System.out.println("Number of purchased tickets: " + ticketsPurchased);
                    System.out.println("Percentage: " + String.format("%.2f", ((float) ticketsPurchased/(rows*seats)*100)) + "%");

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

    public static char[][] reservedSeats(char[][] cinemaSeats,int rows, int seats) {

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
}