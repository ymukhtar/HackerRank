package h101;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/14/17.
 */
public class CupCakes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] calories = new Integer[n];
        for(int calories_i=0; calories_i < n; calories_i++){
            calories[calories_i] = in.nextInt();
        }
        Arrays.sort(calories,Comparator.reverseOrder());
       // System.out.println(Arrays.toString(calories));
        long old_agg =0 ;
        for(int c =0;c<calories.length;c++){
            old_agg = old_agg+ (long)Math.pow(2.0,1.0*c)*calories[c];
        }
        System.out.println(old_agg);
        // your code goes here
    }
}
