import java.util.Scanner;
/*
Given a two-dimensional array (matrix) and the two numbers: i and j. Swap the columns with indexes i and j within the matrix.

Input contains matrix dimensions n and m, not exceeding 100, then the elements of the matrix, then the indexes i and j.
 */
public class SwapColumns {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] array = new int[row][cols];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int indxN = scanner.nextInt();
        int indxS = scanner.nextInt();

        for (int i = 0; i < row; i++) {
            int temp = array[i][indxN];
            array[i][indxN] = array[i][indxS];
            array[i][indxS] = temp;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
