package crackingcode;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/24/17.
 */
public class CheckPrimality {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for (int a0 = 0; a0 < p; a0++) {
            int n = in.nextInt();
            if(isPrime(n))
                System.out.println("Prime");
            else
                System.out.println("Not prime");
        }
    }

    private static boolean isPrime(int n) {
        if(n<2)
            return false;
        else if(n==2 || n==3)
            return true;
        else if((n&1)==0)
            return false;

        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
