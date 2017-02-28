package queues;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/21/17.
 */
public class QueriesWithFixedLength {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), q = in.nextInt();
        int[] seq = new int[n];
        for(int i=0;i<n;i++)
            seq[i] = in.nextInt();
        int d;
        for(int j=0;j<q;j++){
            d = in.nextInt();
            System.out.println(getMin(seq,d));
        }
    }

    private static int getMin(int[] seq, int d) {
        //slide window of d size
        int min_of_max = Integer.MAX_VALUE;
        int old_max = Integer.MIN_VALUE;
        for(int i=0;i<=seq.length-d;i++){
            int max = Integer.MIN_VALUE;
            if(i==0 ||  old_max == seq[i-1]) {
                for (int j = i; j < i + d; j++) {
                    max = Math.max(seq[j], max);
                }
                old_max = max;
            }
            else{
                max = Math.max(seq[i+d-1], old_max);
            }
            min_of_max = Math.min(min_of_max,max);
        }
        return min_of_max;
    }
}
