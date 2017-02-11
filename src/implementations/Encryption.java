package implementations;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/25/17.
 */
public class Encryption {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input= in.nextLine().replaceAll(" ","");
        int length = input.length();
        double sqrt = Math.sqrt(length);
        int rows = (int)Math.floor(sqrt);
        int cols = (int)Math.ceil(sqrt);

        if(rows*cols<length){
            int conf1 = (rows)*(cols+1);
            int conf2 = (rows+1)*(cols);
            if(conf1>conf2)
                cols++;
            else
                rows++;
        }

        char[][] matrix = new char[rows][cols];
        int sIndex=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(sIndex<length)
                    matrix[i][j]=input.charAt(sIndex++);
                else
                    matrix[i][j]=' ';
            }
        }
        StringBuffer output = new StringBuffer();
        for(int j=0;j<cols;j++) {
            for (int i = 0; i < rows; i++) {
                if(matrix[i][j]!=' '){
                    output.append(matrix[i][j]);
                }
            }
            output.append(' ');
        }
        System.out.println(output.toString().trim());
    }
}

