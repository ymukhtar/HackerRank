package sorting;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/29/17.
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] counting = new int[100];
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        for(int i=0;i<total;i++){
            int v = in.nextInt();
            counting[v] += 1;
        }
        for(int i=0;i<counting.length;i++){
            System.out.print(counting[i]+" ");
        }
    }
}
