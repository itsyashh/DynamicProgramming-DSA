package DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;

public class KnapswapFactorial {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] values = new int[n];
        int[] wts = new int[n];

        for (int i = 0; i < values.length; i++) {
            values[i] = scn.nextInt();
        }
        for (int i = 0; i < wts.length; i++) {
            wts[i] = scn.nextInt();
        }

        int cap = scn.nextInt();

        Item [] items = new Item[n];
        for(int i = 0; i < n; i++){
            items[i] = new Item();
            items[i].wt = wts[i];
            items[i].val = values[i];
            items[i].vwratio = items[i].val * 1.0 / items[i].wt;
        }

        Arrays.sort(items);
        double vib = 0;
        double rc = cap;

        int i = items.length - 1;
        while(i >= 0){
            if(items[i].wt <= rc){
                vib += items[i].val;
                rc -= items[i].wt;
            } else {
                vib += items[i].val * rc / items[i].wt;
                rc = 0;
                break;
            }

            i--;
        }

        System.out.println(vib);
    }

    public static class Item implements Comparable<Item> {
        double wt;
        double val;
        double vwratio;

        public int compareTo(Item o){
            if(this.vwratio == o.vwratio){
                return 0;
            } else if(this.vwratio > o.vwratio){
                return +1;
            } else {
                return -1;
            }
        }
    }
}
