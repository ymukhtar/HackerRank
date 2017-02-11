package DynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/28/17.
 */
public class ModifiedFabonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t1= in.nextInt(), t2= in.nextInt(), n =in.nextInt();
        BigInteger[] memoization = new BigInteger[n];
        memoization[0]=BigInteger.valueOf(t1);
        memoization[1]=BigInteger.valueOf(t2);
        for(int i=2;i<n;i++){
            memoization[i]=memoization[i-2].add(memoization[i-1].multiply(memoization[i-1]));
        }
        System.out.println(memoization[n-1]);
    }
}
