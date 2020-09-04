package DynamicProgramming;
import java.util.Scanner;

public class PartitionOfSubsetDp {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        if(n == 0 || k == 0 || n < k ){
            System.out.println(0);
            return;
        }

        long[][] dp = new long[k + 1][n + 1];
        for(int team = 1; team <= k; team++){
            for(int people = 1; people <=n; people++){
                if(people < team){
                    dp[team][people] = 0;
                }else if(people == team){
                    dp[team][people] = 1;
                }else {
                    dp[team][people] = dp[team -1][people -1] + dp[team][people-1]* team;
                }
            }
        }
        System.out.println(dp[k][n]);

    }

}
