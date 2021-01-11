public class Cinema {
    /*
    Work on project. Stage 1/5: Arrangement

        Objectives
        There is not a lot of space in our new cinema theatre, so you need to take into account the restrictions on the number of seats.
        Your friends said that the room would fit 7 rows of 8 seats. Your task is to help them visualize the seating arrangement by printing the scheme to the console.

        Your output should be like in the example below and should contain 9 lines.

        Example
        Cinema:
          1 2 3 4 5 6 7 8
        1 S S S S S S S S
        2 S S S S S S S S
        3 S S S S S S S S
        4 S S S S S S S S
        5 S S S S S S S S
        6 S S S S S S S S
        7 S S S S S S S S
     */

    public static void main(String[] args) {
        printBoard();
    }

    public static void printBoard(){
        String seats = " ";
        System.out.println("Cinema:");
        for (int i = 1; i <9; i++) {
            seats += " " + i;
        }
        System.out.println(seats);

        for (int i = 1; i < 8; i++) {
            System.out.println(i + " S S S S S S S S");
        }
    }
}
