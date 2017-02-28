package crackingcode;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/24/17.
 */
public class StairCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(getNoOfWays(n));
        }
    }

    private static int getNoOfWays(int n) {
        if(n<3)
            return n;
        int[] memo = new int[n+1];
        memo[1]=1;
        memo[2]=2;
        memo[3]=4;
        for(int i=4;i<=n;i++)
            memo[i] = memo[i-1] +memo[i-2]+memo[i-3];
        return memo[n];
    }
}
