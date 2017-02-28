package crackingcode;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/26/17.
 */
public class ConnectedCellInGrid {
    static int[] x={-1,-1,-1,0,0,1,1,1};
    static int[] y ={-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        int visited[][] = new int[n][m];

        for(int row=0; row < n; row++){
            for(int col=0; col < m; col++){
                grid[row][col] = in.nextInt();
                visited[row][col] =0;
            }
        }

        //possible directions
        int max_region =Integer.MIN_VALUE;
        for(int row=0; row < n; row++){
            for(int col=0; col < m; col++){
               if(grid[row][col]==1 && visited[row][col]==0){
                   max_region = Math.max(max_region, getRegionsFromHere(grid,row,col,visited));
               }
            }
        }
        System.out.println(max_region);

    }

    private static int getRegionsFromHere(int[][] grid, int row, int col,int[][] visisted) {
        visisted[row][col] = 1;
        int nr,nc,size = 1;
        for(int d=0;d<x.length;d++){
            nr = row+x[d];
            nc = col+y[d];
            if( nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1 && visisted[nr][nc]==0){
                size += getRegionsFromHere(grid,nr,nc,visisted);
            }
        }
        return size;
    }
}
