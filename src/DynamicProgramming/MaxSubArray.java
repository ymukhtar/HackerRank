package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/29/17.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test_cases = in.nextInt();
        for(int t=0;t<test_cases;t++){
            int n = in.nextInt();
            int sum =0;
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = in.nextInt();
                if(a[i]>0)
                    sum +=a[i];
            }
            int x = maxSubArray(a);
            if(sum==0)
                sum = x;
            System.out.println(x+" "+sum);
            //"abc".compareTo("def");
        }
    }

    private static int maxSubArray(int[] a) {
        int max_so_far=a[0],max_till_now =a[0];
        for(int i=1;i<a.length;i++){
            max_till_now = Math.max(a[i],max_till_now+a[i]);
            max_so_far = Math.max(max_so_far,max_till_now);
        }
        return max_so_far;
    }
}
