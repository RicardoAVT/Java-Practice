import java.util.Scanner;

/*
The cinema has n rows, each row consists of m seats (n and m do not exceed 20). The two-dimensional matrix stores the information on the sold tickets, number 1 means that the ticket for this place is already sold, the number 0 means that the place is available. You want to buy k tickets to the neighboring seats in the same row. Find whether it can be done.

Input data format

On the input, the program gets the number of n rows and m seats. Then, there are n lines, each containing m numbers (0 or 1) separated by spaces. The last line contains a number k.

Output data format

The program should output the number of the row with k consecutive available seats. If there are several rows with k available seats, output the first row with these seats. If there is no such a row, output the number 0.


 */

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int t = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    boolean found = true;
                    for (int k = 0; k < t; k++) {
                        if (j + k >= m || matrix[i][j + k] != 0) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println(i + 1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
