package DynamicProgramming;
import java.util.Scanner;

public class FibonacciDp {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //NormalFibonacci(n);
        int fb = DynamicFibonacci(n,new int[n+1]);
        System.out.println(fb);

    }
    // Finding Fibonacci number in Normal Method
    public static void NormalFibonacci(int n){
        int n1 = 0;
        int n2 = 1;
        int sum = 0;
        for(int i = 1; i < n; i++){

            sum = n1 + n2;
            n1= n2;
            n2 = sum;
            System.out.print(sum + " ");

        }

    }
    // Finding Fibonacci in Recursion Method

    public static int RecursFibonacci(int n){

        if(n == 0 || n == 1){
            return n;
        }
        
        int fibon1 = RecursFibonacci(n -1);
        int fibon2 = RecursFibonacci(n-2);
        int fibon = fibon1+fibon2;

        return fibon;
    }

    // Finding Fibonacci in dynamic programming method

    public static int DynamicFibonacci(int n, int [] qa){
        if(n == 0 || n == 1){
            return n;
        }
        if(qa [n] != 0){
            return qa[n];
        }

        int fibon1 = DynamicFibonacci(n -1,qa);
        int fibon2 = DynamicFibonacci(n-2,qa);
        int fibon = fibon1+fibon2;
        qa[n] = fibon;
        return fibon;
    }
}
