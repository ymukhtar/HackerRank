package DynamicProgramming;

import java.util.*;

/**
 * Created by yasir_mukhtar on 1/30/17.
 */
public class CoinChangeDP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt(), m = in.nextInt();
        int[] coin_store = new int[m];
        for (int i = 0; i < m; i++) {
            coin_store[i] = in.nextInt();
        }
        // Array T
        long[] t_array = new long[total + 1];
        Arrays.fill(t_array, 0);
        t_array[0] = 1l;

        for(int cIndex=0;cIndex<m;cIndex++){
            for(int t=coin_store[cIndex];t<=total;t++){
               int coin = coin_store[cIndex];
               if(cIndex==0){
                   t_array[t] = (t%coin)==0?1:0;
               }else{
                   t_array[t] = t_array[t] + t_array[t-coin];
               }
            }
            //System.out.println(Arrays.toString(t_array));
        }


        System.out.println(t_array[total]);
    }
}
