package implementations;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/24/17.
 */
public class LongFactorials {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger factorial = BigInteger.valueOf(1l);
        for(int i=2;i<=n;i++){
            factorial =  factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial.toString());
    }
}
