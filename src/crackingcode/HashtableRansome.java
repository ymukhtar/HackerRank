package crackingcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/2/17.
 */
public class HashtableRansome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        System.out.println(isPossible(magazine,ransom));

    }

    private static String isPossible(String[] magazine, String[] ransom) {
        if(magazine.length<ransom.length){
            return "No";
        }
        Arrays.sort(magazine);
        Arrays.sort(ransom);
        int rIdx=0,mIdx=0;
        while(rIdx<ransom.length&&mIdx<magazine.length){
            int comp = ransom[rIdx].compareTo(magazine[mIdx]);
            if(comp==0){
                rIdx++;
                mIdx++;
            }
            else if(comp<0){
                return "No";
            }
            else{
                mIdx++;
            }
        }
        if(rIdx!=ransom.length){
            return "No";
        }

        return "Yes";
    }
}
