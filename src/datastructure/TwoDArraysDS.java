package datastructure;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/2/17.
 */
public class TwoDArraysDS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r =6,c=6;
        int[][] matrix = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j] = in.nextInt();
            }
        }
        int[] col={0,1,2,1,0,1,2};
        int[] row={0,0,0,1,2,2,2};
        int max = Integer.MIN_VALUE;
        for(int i=0;i<r-2;i++){
            for(int j=0;j<c-2;j++){
                int sum =0;
                for(int ii=0;ii<col.length;ii++){
                    sum +=matrix[i+row[ii]][j+col[ii]];
                }
                if(max<sum)
                    max=sum;
            }
        }
        System.out.println(max);
    }
}
