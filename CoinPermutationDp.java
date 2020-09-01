package DynamicProgramming;
import java.util.Scanner;

public class CoinPermutationDp {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] amt = new int[n];
        for(int i = 0; i < amt.length; i++){
            amt[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        int [] dp = new int[target + 1];
        dp[0] = 1;

        for(int i = 1; i < dp.length; i++ ){
            for(int j = 0; j < amt.length; j++){
                if(amt[j] <= i){
                    dp[i] = dp[i] + dp[i- amt[j]];
                }
            }
        }
        System.out.println(dp[target]);
    }
}
