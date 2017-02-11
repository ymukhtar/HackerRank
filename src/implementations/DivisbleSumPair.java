package implementations;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/23/17.
 */
public class DivisbleSumPair {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int pairs = 0;

        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                pairs += (a[i]+a[j])%k==0?1:0;
            }
        }
        System.out.println(pairs);
    }
}
