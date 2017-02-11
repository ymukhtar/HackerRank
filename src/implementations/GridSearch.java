package implementations;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/26/17.
 */
public class GridSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test_cases = Integer.parseInt(in.nextLine());
        for(int t=0;t<test_cases;t++) {
            String[] row_col = in.nextLine().split(" ");
            int R = Integer.parseInt(row_col[0]);
            int C = Integer.parseInt(row_col[1]);
            int[][] matrix = new int[R][C];
            for (int i = 0; i < R; i++) {
               String row = in.nextLine();
               for(int j=0;j<C;j++){
                   matrix[i][j]=(row.charAt(j)-'0');
               }
            }
            //System.out.println(Arrays.toString(matrix));
            row_col = in.nextLine().split(" ");
            int r = Integer.parseInt(row_col[0]);
            int c = Integer.parseInt(row_col[1]);
            int[][] pattern = new int[r][c];
            for (int i = 0; i < r; i++) {
                String row = in.nextLine();
                for(int j=0;j<c;j++){
                    pattern[i][j]=(row.charAt(j)-'0');
                }
            }
            gridSearch(matrix,pattern,R,C,r,c);
        }
    }

    private static void printMatrix(int[][] m){
        for(int i=0;i<m.length;i++){
            System.out.println(Arrays.toString(m[i]));
        }
    }

    private static void gridSearch(int[][] matrix, int[][] pattern, int r, int c, int r1, int c1) {
        for(int i=0;i<r-r1+1;i++){
            for(int j=0;j<c-c1+1;j++){
                if(matchWindow(matrix,i,j,r1,c1,pattern)){
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

//    private static boolean compareWindowAndPattern(int[][] window, int[][] pattern) {
//        boolean matched = true;
//        for(int i=0;i<pattern.length;i++){
//            matched = matched && Arrays.equals(window[i], pattern[i]);
//            if (!matched)
//                return false;
//        }
//        return matched;
//    }

    private static boolean matchWindow(int[][] matrix, int sr, int sc, int r, int c,int[][] pattern) {
        boolean matched = true;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matched= matched && (pattern[i][j]==matrix[i+sr][j+sc]);
                if(!matched)
                    return false;
            }
        }
        return matched;
    }

//    private static int[][] extractWindow(int[][] matrix, int sr, int sc, int r, int c) {
//        int[][] window = new int[r][c];
//        for(int i=0;i<r;i++){
//            for(int j=0;j<c;j++){
//                window[i][j]=matrix[i+sr][j+sc];
//            }
//        }
//        return window;
//    }

}
