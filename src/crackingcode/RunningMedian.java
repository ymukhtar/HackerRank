package crackingcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/26/17.
 */
public class RunningMedian {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] a = new int[n];
            a[0] = in.nextInt();
            System.out.printf("%.1f\n",(float)a[0]);
            int end,t;
            for(int a_i=1; a_i < n; a_i++){
                t  = in.nextInt();
                a[a_i] = t;
                end = a_i;
                int mid = a_i/2;
                while(end>0 && t<a[end-1]){
                    a[end] = a[end-1];
                    end --;
                }
                a[end] = t;
                //System.out.println(Arrays.toString(a));
                if((a_i&1)==1){
                    //even elements
                    System.out.printf("%.1f\n",(a[mid]+a[mid+1])/2.0);
                }
                else{
                    System.out.printf("%.1f\n",(float)a[a_i/2]);
                }
            }
        }
}
