package sorting;

import java.util.Scanner;

import static java.util.Arrays.binarySearch;

/**
 * Created by yasir_mukhtar on 1/28/17.
 */
public class CurrentBuffer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value =in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int idx = binarySearch(arr,value);
        System.out.println(idx);
    }
}
