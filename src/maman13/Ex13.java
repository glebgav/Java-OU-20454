package maman13;

public class Ex13 {
    /**
     * Checks if  digits of number  are ascending
     * @param n number to check
     * @return true if number is ascending and false otherwise
     */
    public  static boolean ascendingNum(int n) {
        boolean result = false;
        if (n / 10 == 0) // base case: n is 1 digit number
            result = true;
        else if (n % 10 > (n / 10) % 10) // if last dig is greater then before last digit cut last digit and repeat
            result = ascendingNum(n / 10);
        return result; // return false if both conditions are not met
    }

    /**
     * Return the GCD of two numbers
     * @param m first number
     * @param n second number
     * @return greatest common denominator
     */
    public static int generalGCD(int m,int n) {
        int result;
        if (m % 2 == 0 && n % 2 == 0)
            result = 2 * generalGCD(m / 2, n / 2); // Euclidean algorithm for GCD with two even numbers
        else result = oodGCD(m, n);
        return result;
    }

    /**
     * Return the GCD in case at least one of the numbers are odd
     * @param m first number
     * @param n second number
     * @return  greatest common denominator(in case at least one of the numbers are odd)
     */
    private static int oodGCD(int m,int n) {
        int result;
        if (n == m)
            result = n;
        else if (m > n)
            result = oodGCD(n, m - n);
        else
            result = oodGCD(m, n - m);
        return result;
    }

    /**
     * Prints all substrings at s that starts with 'a' character.
     * @param s string to check
     */
    public static void f(String s)
    {
        if(s.length() == 0)
            return;
        if(s.charAt(0)=='a')
            System.out.println(s);
        f(s.substring(1)); // send s.substring(1) to f
    }
}
