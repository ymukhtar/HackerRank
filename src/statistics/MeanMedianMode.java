package statistics;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/24/17.
 */
public class MeanMedianMode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        double sum =0;
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        System.out.printf("%.1f\n",(sum/n));
        Arrays.sort(arr);
        if((n&1)==1){
            //odd in middle
            System.out.printf("%.1f\n",(float)arr[n/2]);
        }
        else{
             int t= n/2;
            System.out.printf("%.1f\n",(arr[t-1]+arr[t])/2.0);
        }
        //Mode

        Map<Integer,Integer> freq = new LinkedHashMap<Integer,Integer>();
        for(int num : arr){
            freq.putIfAbsent(num,0);
            freq.put(num,freq.get(num)+1);
        }

        int maxFreq = freq.values().stream().max(Comparator.naturalOrder()).get();
        for(Map.Entry<Integer,Integer> entry: freq.entrySet()){
            if(entry.getValue()==maxFreq){
                System.out.printf("%.1f",(float)entry.getKey());
                return;
            }
        }
    }
}
