package strings;

import java.util.*;

/**
 * Created by yasir_mukhtar on 1/28/17.
 */
public class StringConstruction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] unique = new int[26];

        for(int a0 = 0; a0 < n; a0++){
            Arrays.fill(unique,0);
            String next = in.next();
            for(int i=0;i<next.length();i++){
                unique[next.charAt(i)-'a'] =1;
            }
            System.out.println(Arrays.stream(unique).sum());
        }
    }
}
