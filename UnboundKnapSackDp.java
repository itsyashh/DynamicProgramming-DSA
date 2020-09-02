package DynamicProgramming;
import java.util.Scanner;

public class UnboundKnapSackDp {
    public static void main (String [] args){
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
        int [] dp = new int[tar + 1];
        dp[0] = 0;

        for(int bagTar = 1; bagTar < dp.length; bagTar++){
            int max = 0;
            for(int j = 0; j < n; j++){

                if(wts[j] <= bagTar){
                    int remBagTar = bagTar - wts[j];
                    int remBagVal = dp[remBagTar];
                    int totalRemBagVal = remBagVal + val[j];
                    if(totalRemBagVal > max){
                        max = totalRemBagVal;
                    }

                }
            }
            dp[bagTar] = max;

        }
        System.out.println(dp[tar]);

    }
}
