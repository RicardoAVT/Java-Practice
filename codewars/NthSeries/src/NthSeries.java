public class NthSeries {

    /*
    Task:
    Your task is to write a function which returns the sum of following series upto nth term(parameter).

    Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
    Rules:
    You need to round the answer to 2 decimal places and return it as String.

    If the given value is 0 then it should return 0.00

    You will only be given Natural Numbers as arguments.
     */


    public static String seriesSum(int n) {

        float result = 1f;
        float fraction = 1f;

        if (n == 0) {
            return String.format("%.2f", 0);
        }

        for (int i = 1; i < n; i++) {
            fraction += 3;
            result += (1 / fraction);
        }

        return String.format("%.2f", result);
    }
}

