package statistics;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/24/17.
 */
public class WeightedMean {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr= new int[n];
        double sum =0;
        int weighted_sum =0,w;
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            w = in.nextInt();
            sum += (arr[i] * w);
            weighted_sum += w;
        }
        System.out.printf("%.1f\n",(sum/weighted_sum));
    }
}
