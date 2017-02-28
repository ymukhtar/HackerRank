package crackingcode;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/26/17.
 */
public class BubbleSort{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        //
        int total_swaps = 0,last = n-1;
        boolean is_sorted = false;
        while(!is_sorted){
            is_sorted = true;
            for(int i=0;i<last;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                    is_sorted= false;
                    total_swaps++;
                }
            }
            last--;
        }
        System.out.printf("Array is sorted in %d swaps.\n",total_swaps);
        System.out.printf("First Element:%d\n",arr[0]);
        System.out.printf("Last Element:%d\n",arr[n-1]);
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}
