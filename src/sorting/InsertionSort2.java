package sorting;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/28/17.
 */
public class InsertionSort2 {
    public static void insertionSortPart2(int[] ar)
    {
        int x,j;
        for(int i=1;i<ar.length;i++){
            x = ar[i];
            j = i-1;
            while(j>=0 && ar[j]>x){
                ar[j+1] = ar[j];
                j=j-1;
            }
            ar[j+1]=x;
            printArray(ar);
        }
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
