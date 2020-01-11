package maman14;

public class Ex14 {
    private static int CONTINUE=0;
    private static int END_OF_STRING=-1;
    /**
     * return true if string t is a transform of string s and false otherwise.
     * @param s original string
     * @param t transformed string
     * @return true or false if t is a transform of s.
     */
    public static boolean isTrans(String s, String t)
    {
        // check edge case that both or ether of the strings are empty
        if(s.isEmpty()&& t.isEmpty())
            return true;
        if(s.isEmpty()|| t.isEmpty())
            return false;
        return isTrans(s,t,s.charAt(0));
    }
    /**
     * return true if string t is a transform of string s and false otherwise.
     * @param s original string
     * @param t transformed string
     * @param current_char current char to check
     * @return true or false if t is a transform of s.
     */
    public static boolean isTrans(String s, String t, char current_char)
    {
        int []s_counter = charCounter(s,0,current_char);
        int []t_counter = charCounter(t,0,current_char);
        if(s_counter[0]>t_counter[0]) // current char of s  is less(or not present) in t i.e. t is not a transform of s
            return false;
        if(s_counter[1]==END_OF_STRING && t_counter[1]==END_OF_STRING) // both string are empty from charCounter
            return true;
        if(s_counter[1]!=END_OF_STRING && t_counter[1]!=END_OF_STRING) //both string are not empty
            return isTrans(s.substring(s_counter[0]),t.substring(t_counter[0]),s.charAt(s_counter[0])); //go to next char
        return false; //return false if non of the condition are met
    }
    /**
     * counts the number of consecutive chars of a given char in string(char c).
     * stops counting when reached new char or string is empty.
     * if reached new char will return array with counter and CONTINUE(0) indicator
     * if reached end of string will return array with counter and END_OF_STRING(-1) indicator.
     * @param s string to check
     * @param counter counter
     * @param c char to check
     * @return array of counter and END_OF_STRING if string is empty and CONTINUE if not
     */
    public static int[] charCounter(String s,int counter,char c)
    {
        if(s.isEmpty())
            return new int[]{counter,END_OF_STRING};
        if(s.charAt(0)!=c)
            return new int[]{counter, CONTINUE};
        counter++;
        return charCounter(s.substring(1),counter,c);
    }

    /**
     * count the number of valid paths to the last element in matrix
     * @param mat mat
     * @return number of valid paths
     */
    public static int countPaths(int[][] mat)
    {
        return countPaths(mat,0,0);
    }

    /**
     * count the number of valid paths to the last element in matrix
     * @param mat mat
     * @param row row index
     * @param col column index
     * @return number of valid paths
     */
    public static int countPaths(int[][] mat,int row, int col)
    {
        if(row>mat.length-1 || col>mat[0].length-1) // index out of bounce -not a valid path
            return 0;
        if(row==mat.length-1 && col==mat[0].length-1) // hit the last element -  a valid path
            return 1;
        int left_dig = mat[row][col]/10;
        int right_dig = mat[row][col]%10;
        if (left_dig==0 && right_dig==0) // hit zero - can't continue , not a valid path
            return 0;
        int path2=0,path1 = countPaths(mat,left_dig+row,right_dig+col);
        if(left_dig+row!=right_dig+row || right_dig+col!=left_dig+col) // check that path2 is different then path1
            path2 = countPaths(mat,right_dig+row,left_dig+col);
        return path1+path2; //return total of valid path from current index
    }
}