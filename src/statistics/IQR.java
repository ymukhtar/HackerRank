package statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/24/17.
 */
public class IQR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(),f;
        int[] arr= new int[n];
        List<Integer> data_set =  new ArrayList<>();
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            f = in.nextInt();
            while(f-->0){
                data_set.add(arr[i]);
            }
        }
        Integer[] array = data_set.toArray(new Integer[]{});
        Arrays.sort(array);
        double q1,q3;
        n = array.length;
        if((n&1)==1){
            int mid = n/2;
            q1 = getMedian(array,0,mid);
            q3 = getMedian(array,mid+1,n);
        }
        else{
            int point = n/2;
            q1 = getMedian(array,0,point);
            q3 = getMedian(array,point,n);
        }
        System.out.printf("%.1f\n",q3-q1);

    }

    private static double getMedian(Integer[] arr,int sIndex, int eIndex) {
        int l = eIndex-sIndex;
        if((l&1)==1){
            return (double)arr[sIndex+l/2];
        }else{
            int mid = sIndex+(l/2);
            return (arr[mid-1]+arr[mid])/2.0;
        }
    }
}
