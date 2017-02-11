package sorting;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/28/17.
 */
public class InsertionSort {
    public static void insertIntoSorted(int[] ar) {
        // Fill up this function
        int idx = ar.length-1;
        int e = ar[idx];
        idx -=1;
        while(idx>=0 && e<ar[idx]){
            ar[idx+1]=ar[idx];
            idx -=1;
            printArray(ar);
        }
        ar[idx+1] = e;
        printArray(ar);
    }


    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
