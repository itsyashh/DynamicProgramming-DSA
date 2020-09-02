package DynamicProgramming;
import java.util.Scanner;

public class ArrangeBuildingDp {
    public static void main (String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int zb = 1;
        int zs = 1;

        for(int i = 2; i <= n; i++){
            int nzb = zs;
            int nzs = zb + zs;

            zs = nzs;
            zb = nzb;
        }
        int total = zs + zb;
        total = total * total;
        System.out.println(total);
    }
}
