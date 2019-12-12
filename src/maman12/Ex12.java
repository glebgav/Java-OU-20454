package maman12;
import java.util.Arrays;

public class Ex12 {
    /**
     * Return how many sub-strings exists that starts and ends with a given char and contains maximun one time of the given char
     * @param s string
     * @param c char to look for
     * @return how many sub-strings exists that starts and ends with c and have maximun one c between
     */
    //Time Complexity O(n),n is s.length, Space Complexity O(1)
    public static int subStrC(String s, char c)
    {
        int count = 0;
        boolean isC,found = false;
        int foundSecond = 0;
        for (int i=0;i < s.length() ; i++)
        {
            isC = (s.charAt(i) == c);
            if (isC && !found)  //check if found first c
                found = true;
            else if (found && isC && foundSecond == 0)   //check if found second c
                foundSecond = i;
            else if (isC) // //check if found next c
            {
                count++;
                i = foundSecond;
                foundSecond = 0;
            }
        }
        return count;
    }

    /**
     * Return how many sub-strings exists that starts and ends with a given char and contains maximun of a given number
     * of times of the given char.
     * @param s string
     * @param c char to look for
     * @param k number
     * @return how many sub-strings exists that starts and ends with c and have maximun k times of c between
     */
    //Time Complexity O(n), n is s.length, Space Complexity O(1)
    public static int subStrMaxC(String s,char c, int k)
    {
        int sub_count = 0,foundSecond = 0,found = 0;
        boolean isC,foundFirst  = false;
        if (k < 0)
            return sub_count;
        for (int i=0;i < s.length() ; i++)
        {
            isC = (s.charAt(i) == c);
            if (isC && !foundFirst )
                foundFirst = true;
            else if (foundFirst && isC  && found +1 > k && foundSecond == 0)
            {
                found =0;
                foundSecond = i;
                foundFirst  = false;
                sub_count++;
            }
            else if (isC && found < k && foundSecond == 0)
            {
                foundSecond = i;
                found ++;
                sub_count++;
            }
            else if (isC && found < k)
            {
                found ++;
                sub_count++;
            }
            else if (isC)
            {
                sub_count++;
                i = foundSecond;
                foundSecond = 0;
                found = 0;
            }
            if (foundSecond > 0 && i+1 == s.length())
            {
                i = foundSecond;
                foundSecond = 0;
                found = 0;
            }
        }
        return sub_count;
    }
    /**
     * Given an array of n integers, for each element, prints the distance to the closest zero. Array has a minimum of 1 zero in it.
     * @param a array of 1 and 0.
     */
    //Time Complexity O(n),n is a.length, Space Complexity O(n)
    public static void zeroDistance(int[] a)
    {
        // initializes an array of size a.length with 0
        int n = a.length;
        int[] ans =new int[n];
        Arrays.fill(ans,0);
        // if first element is 0 then the distance
        // will be 0
        if (a[0] == 0)
            ans[0] = 0;

            // if not 0 then initialize
            // with a maximum value of n
        else
            ans[0] = n ;

        // traverse in loop from 1 to n and store
        // the distance from left
        for (int i = 1; i < n; ++i)
        {
            // add 1 to the distance
            // from previous one
            ans[i] = ans[i - 1] + 1;
            // if the present element is
            // 0 then distance will be 0
            if (a[i] == 0)
                ans[i] = 0;
        }
        // if last element is zero
        // then it will be 0 else
        // let the answer be what was
        // found when traveled
        // form left to right
        if (a[n - 1] == 0)
            ans[n - 1] = 0;
        // traverse from right to
        // left and store the minimum
        // of distance if found from
        // right to left or left
        // to right
        for (int i = n - 2; i >= 0; --i)
        {
            // store the minimum of distance
            // from left to right or right to left
            ans[i] = Math.min(ans[i], ans[i + 1] + 1);
            // if it is 0 then minimum
            // will always be 0
            if (a[i] == 0)
                ans[i] = 0;
        }
        // print the answer array
        for (int i = 0; i < n; ++i)
            System.out.print(ans[i] + " ");
    }
}
