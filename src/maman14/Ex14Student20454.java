package maman14;

/**
 * Write a description of class Ex14Student20454 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ex14Student20454
{

    public static void main(String[] argv) 
    {
        System.out.println("\n====================================\n\nTesting Question 1\n------------------------------------\n");
        boolean result=Ex14.isTrans("abbcd","aabbccdd");
        System.out.println("isTrans method returns " + result + " for abbcd and aabbccdd - should return true"); //expected true
        result=Ex14.isTrans("abbcd","abcd");
        System.out.println("isTrans method returns " + result + " for abbcd and abcd - should return false"); //expected true

        System.out.println("\n====================================\n\nTesting Question 2\n------------------------------------\n");
        System.out.println ("*** Testing countPaths question #2 ***");
        System.out.println ("**************************************");

        int[][]matrix = new int[][] {{12,22,23,54},{43,35,21,20},{34,21,43,21},
                {25,30,0,20},{0,22,10,10 }, {20,13,3,45}};
        printMatrix (matrix);
        int count = Ex14.countPaths (matrix);
        System.out.println ("countPaths is: " + count + "\t should be: 3");
        System.out.println ();

        matrix = new int[][] {{12,22,23,54},{43,35,21,20},{34,11,43,21},
                {25,30,0,20},{0,22,10,10 }, {20,13,10,45}};
        printMatrix (matrix);
        count = Ex14.countPaths (matrix);
        System.out.println ("countPaths is: " + count + "\t should be: 1");
        System.out.println ();

        matrix = new int[][] {{12,22,23,54},{43,35,21,20},{34,11,43,21},
                {25,30,10,20},{0,22,10,10 }, {20,13,10,45}};
        printMatrix (matrix);
        count = Ex14.countPaths (matrix);
        System.out.println ("countPaths is: " + count + "\t should be: 4");
        System.out.println ();


        matrix = new int[][] {{13,22,23,54},{43,35,21,20},{34,11,43,21},
                {25,22,10,20},{0,22,10,10 }, {20,13,10,45}};
        printMatrix (matrix);
        count = Ex14.countPaths (matrix);
        System.out.println ("countPaths is: " + count + "\t should be: 2");
        System.out.println ();

        matrix = new int[][] {{10,22,23,54},{43,35,21,20},{34,11,43,21},
                {25,10,10,20},{0,22,10,10 }, {20,13,10,45}};
        printMatrix (matrix);
        count = Ex14.countPaths (matrix);
        System.out.println ("countPaths is: " + count + "\t should be: 1");
        System.out.println ();

        matrix = new int[][] {{10,11,23,54},{23,35,21,20},{34,11,43,21},
                {25,10,10,20},{0,22,10,10 }, {20,13,10,45}};
        printMatrix (matrix);
        count = Ex14.countPaths (matrix);
        System.out.println ("countPaths is: " + count + "\t should be: 4");
        System.out.println ();

        matrix = new int[][] {{10,11,23,54},{23,35,10,20},{34,11,11,21},
                {25,10,10,20},{0,22,10,10 }, {20,13,10,45}};
        printMatrix (matrix);
        count = Ex14.countPaths (matrix);
        System.out.println ("countPaths is: " + count + "\t should be: 5");
        System.out.println ();

    }
    // prints two dimentional array
    public static void printMatrix(int[][] values){
        System.out.print("The matrix is: \n");
        for (int i=0; i<values.length; i++){
            for (int j=0; j<values[0].length;j++)
                System.out.print("\t"+ values[i][j]);
            System.out.println();
        }
    }
}
