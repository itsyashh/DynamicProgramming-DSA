package DynamicProgramming;
import java.util.Scanner;

public class ZeroOneKnapSackDP {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int [] val = new int[n];
        int [] wts = new int[n];

        for(int i = 0; i < val.length; i++){
            val[i] = scn.nextInt();
        }
        for(int i = 0; i < wts.length; i++){
            wts[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        int[][] dp = new int[n + 1][tar + 1];


        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j >= wts[i - 1]){  // if i bat
                    int remTar = j - wts[i - 1];
                    if(dp[i - 1][remTar] + val[i - 1] > dp[i - 1][j]){
                        dp[i][j] = dp[i - 1][remTar] + val[i - 1];
                    }else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }else {
                    dp[i][j] = dp[i - 1][j]; // if i don't bat
                }
            }
        }
        System.out.println(dp[n][tar]);
    }
}
