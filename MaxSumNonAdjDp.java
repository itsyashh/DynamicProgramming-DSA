package DynamicProgramming;

import java.util.Scanner;

public class MaxSumNonAdjDp {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int inc = arr[0];
        int exc = 0;
        for(int i = 1; i < arr.length; i++){

            int ninc = exc + arr[i];
            int nexc = Math.max(inc, exc);

            inc = ninc;
            exc = nexc;
        }
        int max = Math.max(inc, exc);
        System.out.println(max);
    }
}
