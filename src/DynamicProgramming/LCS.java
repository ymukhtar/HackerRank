package DynamicProgramming;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/1/17.
 */
public class LCS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] s1 = new int[n];
        int[] s2 = new int[m];

        for(int i=0;i<n;i++)
            s1[i] = in.nextInt();
        for(int j=0;j<m;j++)
            s2[j] = in.nextInt();

        int[][] matrix = new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            matrix[i][0] = 0;
        }
        for(int j=0;j<n+1;j++){
            matrix[0][j] = 0;
        }
        for(int row=1;row<m+1;row++){
            for(int col=1;col<n+1;col++){
                if(s1[col-1]==s2[row-1]){
                    matrix[row][col] = 1 + matrix[row-1][col-1];
                }
                else {
                    matrix[row][col] = Math.max(matrix[row-1][col],matrix[row][col-1]);
                }
            }
        }
        //print(matrix);
        printSeq(matrix,s1,s2);
    }

    private static void printSeq(int[][] matrix,int[] s1,int[] s2) {
        Stack<Integer> s = new Stack<>();
        for (int x = s2.length, y = s1.length; x != 0 && y != 0; ) {
            if (matrix[x][y] == matrix[x-1][y])
                x--;
            else if (matrix[x][y] == matrix[x][y-1])
                y--;
            else {
                s.add(s2[x-1]);
                x--;
                y--;
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

    private static void print(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
