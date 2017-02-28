package statistics;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/24/17.
 */
public class SD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr= new int[n];
        double sum = 0.0d;
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        double mean = sum/n;
        double sdSum =0.0d;
        for(int i=0;i<n;i++){
            sdSum += Math.pow(arr[i]-mean,2.0);
        }
        System.out.printf("%.1f",Math.sqrt(sdSum/n));
    }
}
