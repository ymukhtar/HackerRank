package datastructure;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/9/17.
 */
public class JesseCookies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() , k = in.nextInt();
        Queue<Integer> myQ = new PriorityQueue<>(Integer::compareTo);
        for(int i=0;i<n;i++){
            myQ.add(in.nextInt());
        }
       //
        int sweetness,ops=0;
        while(!myQ.isEmpty() && myQ.size()>1){
            if(myQ.peek()<k) {
                sweetness = myQ.poll() + 2 * myQ.poll();
                myQ.add(sweetness);
                ops++;
            }else{
                System.out.println(ops);
                return;
            }
        }
        if(!myQ.isEmpty() && myQ.peek()>=k)
            System.out.println(ops);
        else
         System.out.println(-1);
    }
}
