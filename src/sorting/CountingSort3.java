package sorting;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/29/17.
 */
public class CountingSort3 {
    public static void main(String[] args) {
        int[] counting = new int[100];
        String s;
        int v;
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        for(int i=0;i<total;i++){
             v = in.nextInt();
             s = in.next();
            counting[v] += 1;
        }
        int acc =0;
        for(int i=0;i<counting.length;i++){
            acc += counting[i];
            System.out.print(acc + " ");
        }
    }
}
