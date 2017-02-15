package h101;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/13/17.
 */
public class Sequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n+1];

        for(int i=1;i<=n;i++){
            int num = in.nextInt();
            p[num] = i;
        }
        for(int x=1;x<=n;x++){
            System.out.println(p[p[x]]);
        }

    }
}
