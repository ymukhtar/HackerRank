package statistics;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/24/17.
 */
public class Quartiles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        if((n&1)==1){
            int mid = n/2;
            System.out.printf("%d\n",(int)getMedian(arr,0,mid));
            System.out.printf("%d\n",(int)getMedian(arr,0,n));
            System.out.printf("%d\n",(int)getMedian(arr,mid+1,n));
        }
        else{
            double mid = getMedian(arr,0,n);
            int point = n/2;
            System.out.printf("%d\n",(int)getMedian(arr,0,point));
            System.out.printf("%d\n",(int)mid);
            System.out.printf("%d\n",(int)getMedian(arr,point,n));
        }

    }

    private static double getMedian(int[] arr,int sIndex, int eIndex) {
        int l = eIndex-sIndex;
        if((l&1)==1){
            return (double)arr[sIndex+l/2];
        }else{
            int mid = sIndex+(l/2);
            return (arr[mid-1]+arr[mid])/2.0;
        }
    }
}
