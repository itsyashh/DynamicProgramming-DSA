package DynamicProgramming;
import java.util.Scanner;

public class ClimbStairDp {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int print = CountStairTabulation(n);
        //int print = CountStairPath(n, new int[n+1]);
        System.out.println(print);
    }

    // by memoization method in DP
    public static int CountStairPath(int n, int [] qa){
        if(n == 0 ){
            return 1;
        }else if(n < 0){
            return 0;
        }
        if(qa[n] != 0){
            return qa[n];
        }
        System.out.print(n + " ");
        int p1 = CountStairPath(n -1, qa);
        int p2 = CountStairPath(n -2, qa);
        int p3 = CountStairPath(n -3, qa);
        int path = p1 + p2 + p3;
        qa[n] = path;
        return path;
    }

    // by tabulation method in DP
    // steps : 1. Create array for table of size n + 1
    // steps : 2. define direction 0 --> n
    // steps : 3.

    public static int CountStairTabulation(int n ){
       int [] arr = new int[n + 1];
       arr[0] = 1;
       for(int i = 1; i <= n; i++){
           if(i == 1){
               arr[i] = arr[i -1];
           }else if( i == 2){
               arr[i] = arr[i -1] + arr[i - 2];
           }else {
               arr[i] = arr[i -1] + arr[i - 2] + arr[i - 3];
           }
       }
       return arr[n];
    }
}
