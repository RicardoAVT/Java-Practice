public class Accumulator {
    public static String accum(String s) {
        /*
        Instructions

        This time no story, no theory. The examples below show you how to write function accum:

        Examples:

        accum("abcd") -> "A-Bb-Ccc-Dddd"
        accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
        accum("cwAt") -> "C-Ww-Aaa-Tttt"

        The parameter of accum is a string which includes only letters from a..z and A..Z.
         */
        String result = "";
        int count = 0;
        int value = 0;

        for (int i = 0; i < s.length(); i++) {
            result += Character.toUpperCase(s.charAt(i));
            while (count > 0) {
                result += Character.toLowerCase(s.charAt(i));
                count--;
            }
            if (value < s.length() - 1) {
                result += "-";
                value++;
                count = value;
            }
        }
        return result;
    }
}
