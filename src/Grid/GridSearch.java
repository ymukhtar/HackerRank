package Grid;

import java.util.Arrays;

/**
 * Created by yasir_mukhtar on 1/27/17.
 */
public class GridSearch {

    private static int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };


    public static void main(String[] args) {
        char[][] grid = {"GEEKSFORGEEKS".toCharArray(),
                         "GEEKSQUIZGEEK".toCharArray(),
                         "IDEQAPRACTICE".toCharArray()
                        };
        printGrid(grid);
        patternSearch(grid, "GEEKS");
        System.out.println("\n-----------");
        patternSearch(grid, "EEE");
    }

    private static void printGrid(char[][] grid) {
        for(int i=0;i<grid.length;i++){
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    private static void patternSearch(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i< rows; i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==word.charAt(0)){
                    if(findPatternInAllDir(grid,i,j,word,rows,cols)){
                        System.out.printf("\npattern exists at:%d,%d ",i,j);
                    }
                }
            }
        }
    }

    private static boolean findPatternInAllDir(char[][] grid, int i, int j, String word, int rows, int cols) {
        for(int d=0;d<x.length;d++){
            int rn =i+x[d],cn=j+y[d];
            boolean matched = true;
            int k;
            for(k=1;k<word.length();k++) {
                if (rn < 0 || rn >= rows || cn < 0 || cn >= cols) {
                    break;
                }
                matched = matched && (word.charAt(k) == grid[rn][cn]);
                if(!matched)
                    break;
                rn += x[d];
                cn += y[d];
            }
            if(k==word.length())
                return matched;
        }
        return false;
    }
}
