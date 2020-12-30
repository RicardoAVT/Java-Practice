import java.util.Scanner;

/*
Triples

Write a program that reads an array of ints and outputs the number of "triples" in the array.

A "triple" is three consecutive ints in increasing order differing by 1 (i.e. 3,4,5 is a triple, but 5,4,3 and 2,4,6 are not).

Input data format

The first line contains the size of an array.
The second line contains elements of the array separated by spaces.

Output data format

Only a single integer value: the number of "triples".
 */

public class Triplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int len = sc.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        for (int i = 0; i < array.length - 2; i++) {
            if (array[i + 1] == array[i] + 1 && array[i + 2] == array[i] + 2) {
                count++;
            }
        }
        System.out.println(count);
    }
}
