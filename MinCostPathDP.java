package DynamicProgramming;

import java.util.Scanner;

public class MinCostPathDP {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] origArr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                origArr[i][j] = scn.nextInt();
            }
        }

        // we are creating dp array for storing the value of path

        int [][] dp = new int[n][m];

        for(int i = dp.length -1; i >= 0; i--){
            for(int j = dp[0].length -1; j >= 0; j--){

                // we are dividing dp array in four parts 1. [i][j]
                //                                        2. [last row]
                //                                        3. [last col]
                //                                        4. [rest row col]

                if(i == dp[0].length -1 && j == dp[0].length -1){

                    dp[i][j]= origArr[i][j];

                }else if(i == dp[0].length - 1){

                    dp[i][j] = dp[i][j+1] + origArr[i][j];

                }else if(j == dp[0].length - 1){

                    dp[i][j] = dp[i + 1][j] + origArr[i][j];

                }else {

                    dp[i][j] = Math.min(dp[i + 1][j],dp[i][j+1]) + origArr[i][j];

                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
