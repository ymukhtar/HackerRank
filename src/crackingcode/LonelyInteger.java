package crackingcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/24/17.
 */
public class LonelyInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        if(n==1){
            System.out.println(arr[0]);
        }
        else {
            int i;
            Arrays.sort(arr);
            //System.out.println(Arrays.toString(arr));
            for (i=0; i < n - 1; i += 2) {
                if (arr[i] != arr[i + 1]) {
                    System.out.println(arr[i]);
                    return;
                }
            }
            if(i<n)
             System.out.println(arr[i]);
        }
    }
}
