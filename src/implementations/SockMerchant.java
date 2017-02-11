package implementations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by yasir_mukhtar on 1/23/17.
 */
public class SockMerchant {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int pairs =0,t=0;
        Map<Integer,Integer> sock_count = new HashMap<>();
        for(int i =0; i<n;i++){
            t= in.nextInt();
            if(sock_count.containsKey(t)){
                pairs++;
                sock_count.remove(t);
            }else{
                sock_count.put(t,1);
            }
        }
        System.out.println(pairs);
    }
}
