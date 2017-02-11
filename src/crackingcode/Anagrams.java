package crackingcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/2/17.
 */
public class Anagrams {

    public static int numberNeeded(String first, String second) {
        if((first == null || first.isEmpty() ) && (second == null || second.isEmpty())){
            return 0;
        }
        else if((first == null || first.isEmpty()) && (second!=null && second.length()>0)){
            return second.length();
        }
        else if((second == null || second.isEmpty()) && (first!=null && first.length()>0)){
            return first.length();
        }
        int to_delete = 0;
        char[] a= first.toCharArray();
        char[] b = second.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);
        int i=0,j=0;
        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                i++;
                j++;
            }
            else if(a[i]<b[j]){
                to_delete++;
                i++;
            }
            else{
                to_delete++;
                j++;
            }
        }
        if(i<a.length-1){
            to_delete += a.length-i;
        }
        else if(j<a.length-1){
            to_delete += b.length-j;
        }
        return to_delete;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
