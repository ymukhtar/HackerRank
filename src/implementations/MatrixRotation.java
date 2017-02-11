package implementations;

import java.util.*;

/**
 * Created by yasir_mukhtar on 1/24/17.
 */
public class MatrixRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt(), r = in.nextInt();

        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = in.nextInt();
            }
        }

        int total_layers = Math.min(m,n)/2;
        List<LinkedList<Integer>> layers = new ArrayList<>(total_layers);
        for(int l =0;l<total_layers;l++){
            //layers
           //row 0
            LinkedList<Integer> currentList = new LinkedList<>();
            //upper row
            for(int col=0+l;col<n-l;col++){
                currentList.add(Integer.valueOf(matrix[l][col]));
            }
            //right col
            for(int row=1+l;row<m-l;row++){
                currentList.add(Integer.valueOf(matrix[row][n-l-1]));
            }
            //bottom row
            for(int col=n-l-2;col>=l;col--){
                currentList.add(Integer.valueOf(matrix[m-l-1][col]));
            }
            //Left Col
            for(int row=m-l-2;row>l;row--){
                currentList.add(Integer.valueOf(matrix[row][l]));
            }
            //Rotate Layer r times
            int rotation = r%currentList.size();
            while(rotation-->0){
                currentList.add(currentList.pollFirst());
            }
//            System.out.println("Layer--"+l);
//            System.out.println(currentList);
            layers.add(currentList);
        }

        for(int l =0;l<total_layers;l++) {
            LinkedList<Integer> layer = layers.get(l);
            //upper row
            for(int col=0+l;col<n-l;col++){
               matrix[l][col]=layer.pollFirst();
            }
            //right col
            for(int row=1+l;row<m-l;row++){
                matrix[row][n-l-1]=layer.pollFirst();
            }
            //bottom row
            for(int col=n-l-2;col>=l;col--){
                matrix[m-l-1][col]=layer.pollFirst();
            }
            //Left Col
            for(int row=m-l-2;row>l;row--){
                matrix[row][l]=layer.pollFirst();
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        int rows = matrix.length,cols = matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j]+(j<cols-1?" ":""));
            }
            System.out.println();
        }
    }
}
