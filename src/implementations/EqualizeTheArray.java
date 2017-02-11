package implementations;

import java.util.*;

/**
 * Created by yasir_mukhtar on 1/26/17.
 */
public class EqualizeTheArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int[] arr = new int[n];
        Integer temp;
        Map<Integer,Integer> freqMap= new HashMap<>(n);
        for(int i=0;i<n;i++){
            temp = in.nextInt();
            Integer count =0;
            if(freqMap.containsKey(temp)){
                count=freqMap.get(temp);
            }
            freqMap.put(temp, count+1);
        }
        int to_del =0;
        List<Integer> list = new ArrayList<>(freqMap.values());
        Collections.sort(list);
       // System.out.println(freqMap);
        while(list.size()!=1){
            to_del += list.remove(0);
        }
        System.out.println(to_del);
    }
}
