package DynamicProgramming;
import java.util.Scanner;

public class StockAndSellKTransaction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int[][] dp = new int[k + 1][n];

        for(int t = 0; t <= k; t++){
            for(int d = 1; d < n; d++){
                int max = dp[t][d - 1];

                for(int pd = 0; pd < d; pd++){
                    int ptillml = dp[t - 1][pd];
                    int ptth = arr[d] - arr[pd];

                    if(ptillml + ptth > max){
                        max = ptillml + ptth;
                    }
                }
                dp[t][d] =max;
            }
        }
        System.out.println(dp[k][n - 1]);
    }
}
