package datastructure;

import java.util.*;
/**
 * Created by yasir_mukhtar on 2/6/17.
 */
public class AlgorithmicCrush {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        long a,b,v;
        Map<Long,Long> myRange = new HashMap<>(n);
        for(long i=0;i<m;i++){
            a = in.nextLong(); b = in.nextLong() ; v =in.nextLong();
            for(long j=a-1;j<b;j++){
                if(myRange.containsKey(j)){
                    myRange.put(j,myRange.get(j)+v);
                }
                else{
                    myRange.put(j,v);
                }
            }
        }
        System.out.println(myRange.values().stream().max(Long::compareTo).get());
    }
}