package maman12;
import java.util.Arrays;

public class Ex14 {
    public static int subStrC(String s, char c) {
        int i = 0, c_count = 0;
        if (s.length() < 3)
            return 0;
        while (i < s.length()) {
            if (s.charAt(i) == c)
                c_count++;
            i++;
        }
        if (c_count < 3)
            return 0;
        return c_count - 2;
    }
    private static int[] getBoundaries(String s ,char c)
    {
        int len = s.length();
        int leftBoundary=0,rightBoundary=len -1;
        while(s.charAt(leftBoundary) != c && leftBoundary<len-1)
            leftBoundary++;
        while(s.charAt(rightBoundary) != c && rightBoundary > 0)
            rightBoundary--;
        return new int[]{leftBoundary, rightBoundary};
    }
    public static int subStrMaxC(String s,char c, int k)
    {
        int[] boundaries;
        boundaries = getBoundaries(s,c);
        if(boundaries[0] == boundaries[1])
            return 0;
        int totalCount=0,c_count=0;
        int startWindow = boundaries[0]+1;
        int endWindow = boundaries[0] +1;
        for(;endWindow<=boundaries[1]; endWindow++)
        {
           if(c_count==1 || endWindow==boundaries[1])
           {
               while (startWindow<=endWindow){
                   if(s.charAt(startWindow) == c && k>0) {
                       totalCount++;
                       c_count--;
                   }
                   startWindow++;
               }
           }
           if(s.charAt(endWindow) == c) {
               c_count++;
               totalCount++;
           }
        }
        return totalCount;
    }
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
    public static void main(String[] args) {
        String a = "abcbcabcacab";
        int[] b = { 0, 1, 0, 1, 0, 0, 1, 1, 1,0 };
        System.out.println(subStrMaxC(a,'c',2));
//        System.out.println(subStrC(a, 'c'));
//        zeroDistance(b);
    }
}
