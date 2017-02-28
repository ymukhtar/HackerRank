package crackingcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/24/17.
 */
public class LonelyInteger2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res =0;
        for(int i=0;i<n;i++){
            res ^= in.nextInt();
        }
        System.out.println(res);
    }
}
