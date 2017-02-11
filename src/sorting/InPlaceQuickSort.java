package sorting;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/29/17.
 */
public class InPlaceQuickSort {

    private static int total_steps_quick =0;
    private static int total_steps_insert =0;


    public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
                total_steps_insert++;
            }
            A[j + 1] = value;
        }
       // printArray(A);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i] = in.nextInt();
        }
        int[] ar2 = new int[s];
        System.arraycopy(ar,0,ar2,0,s);
        quickSort(ar,0,s-1);
        insertionSort(ar2);

        System.out.println(total_steps_insert-total_steps_quick);
    }

    private static void quickSort(int[] ar, int startIndex, int endIndex) {
        if(startIndex<endIndex) {
            int position = partition(ar, startIndex, endIndex);
            quickSort(ar, startIndex, position-1);
            quickSort(ar, position+1, endIndex);
        }
    }

    private static int partition(int[] ar, int startIndex, int endIndex) {
        int pivot = ar[endIndex];
        int i = startIndex;
        for(int j=startIndex;j<=endIndex-1;j++){
            if(ar[j]<=pivot){
                swap(ar,i,j);
                total_steps_quick++;
                i++;
            }
        }
        swap(ar,i,endIndex);
        total_steps_quick++;
        //printArray(ar);
        return i;
    }

    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    private static void swap(int[] a, int i, int j) {
        int temp =a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
