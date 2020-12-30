import java.util.Scanner;

/*
Write a program that reads an array of int's and checks the array is sorted ascending (from smallest to largest number).

Input data format

The first line contains the size of an array.
The second line contains elements of the array separated by spaces.

Output data format

Only a single value: true or false.

 */

public class Ascending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int len = sc.nextInt();
        int[] array = new int[len];
        boolean ascending = true;

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                ascending = false;
                break;
            }
        }
        System.out.println(ascending);
    }
}
