package crackingcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/2/17.
 */
public class ArraysLeft {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(int i=0;i<k;i++){
            rotateLeft(a);
        }
        for(int i:a)
            System.out.print(i+" ");
    }

    private static void rotateLeft(int[] arr){
        int temp = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1] = temp;
    }
}
