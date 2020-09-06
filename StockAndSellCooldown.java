package DynamicProgramming;

import java.util.Scanner;

public class StockAndSellCooldown {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int bstp = -arr[0];
        int sstp = 0;
        int cstp = 0;
        for(int i = 1; i < arr.length; i++){
            int nbstp = 0;
            int nsstp = 0;
            int ncstp = 0;

            if(cstp - arr[i] > bstp){
                nbstp = cstp - arr[i];
            } else {
                nbstp = bstp;
            }

            if(bstp + arr[i] > sstp){
                nsstp = bstp + arr[i];
            } else {
                nsstp = sstp;
            }

            if(sstp > cstp){
                ncstp = sstp;
            } else {
                ncstp = cstp;
            }

            bstp = nbstp;
            sstp = nsstp;
            cstp = ncstp;
        }

        System.out.println(Math.max(sstp, cstp));
    }

}