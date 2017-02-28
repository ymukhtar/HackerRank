package crackingcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/26/17.
 */
public class RunningMedian2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> upper = new PriorityQueue<>(Comparator.naturalOrder());
        int t;
        int size;
        for(int a_i=0; a_i < n; a_i++){
            t  = in.nextInt();
            if(lower.size()>upper.size()){
                if(lower.peek()>t){
                    upper.add(lower.poll());
                    lower.add(t);
                }
                else
                    upper.add(t);
            }
            else {
                if(!upper.isEmpty() &&upper.peek()<t){
                    lower.add(upper.poll());
                    upper.add(t);
                }
                else
                    lower.add(t);
            }
            size = lower.size()+upper.size();
//            System.out.println(size);
//            System.out.println(lower);
//            System.out.println(upper);
            if((size&1)==1){
                //even elements
                System.out.printf("%.1f\n",(float)lower.peek());
            }
            else{
                System.out.printf("%.1f\n",(lower.peek()+upper.peek())/2.0);
            }

        }
    }
}
