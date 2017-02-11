package datastructure;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/7/17.
 */
public class SparseArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> myList = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            myList.add(in.next());
        }
        int q = in.nextInt();
        String s;
        for(int j=0;j<q;j++){
            int count =0;
            s = in.next();
            for(int k=0;k<myList.size();k++){
                if(myList.get(k).equals(s)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}