package DynamicProgramming;
import java.util.Scanner;

public class PaintManyColorHouse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int c = scn.nextInt();
        int[][] arr = new int[n][c];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        for(int j = 0; j < arr[0].length; j++){
            if(arr[0][j] <= min){
                smin = min;
                min = arr[0][j];
            } else if(arr[0][j] <= smin){
                smin = arr[0][j];
            }
        }

        for (int i = 1; i < arr.length; i++) {
            int cmin = Integer.MAX_VALUE;
            int csmin = Integer.MAX_VALUE;

            for(int j = 0; j < arr[i].length; j++){
                if(arr[i - 1][j] != min){
                    arr[i][j] += min;
                } else {
                    arr[i][j] += smin;
                }

                if(arr[i][j] <= cmin){
                    csmin = cmin;
                    cmin = arr[i][j];
                } else if(arr[i][j] <= csmin){
                    csmin = arr[i][j];
                }
            }

            min = cmin;
            smin = csmin;
        }

        System.out.println(min);
    }
}