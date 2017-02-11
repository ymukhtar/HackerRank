package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/29/17.
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        quickSort(ar);
    }

    private static void quickSort(int[] ar) {
        int pivot = ar[0];
        List<Integer> equal = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int j=0;j<ar.length;j++){
            if(ar[j]==pivot){
                equal.add(ar[j]);
            }else if(ar[j]<pivot){
                left.add(ar[j]);
            }else{
                right.add(ar[j]);
            }
        }
        left.addAll(equal);
        left.addAll(right);
        for(int item:left)
            System.out.print(item+" ");
    }
}
