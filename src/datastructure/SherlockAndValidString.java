package datastructure;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/23/17.
 */
public class SherlockAndValidString {

    public static void main(String[] args) {
        Integer[] occurences_count = new Integer[26];
        Arrays.fill(occurences_count,0);
        Scanner in = new Scanner(System.in);
        String s = in.next();
        for(char c:s.toCharArray()){
            occurences_count[c-'a'] +=1;
        }
        //Min PQ
        Queue<Integer> myQ = new PriorityQueue<>(Comparator.naturalOrder());
        for(int i=0;i<26;i++){
            if(occurences_count[i]!=0)
                myQ.add(occurences_count[i]);
        }
        //System.out.println(myQ);
        int first = myQ.remove(),old;
        if(myQ.size()>1) {
            old = myQ.remove();
            while (myQ.size() > 1) {
                if (old != myQ.remove()) {
                    System.out.println("NO");
                    return;
                }
            }
            int last = myQ.remove();
            if(first == old && old!=last  || (first ==old && old==last))
                System.out.println("YES");
            else if(first!=old && old==last)
                System.out.println("YES");

            else
                System.out.println("NO");
        }
        else
            System.out.println("YES");
    }
}
