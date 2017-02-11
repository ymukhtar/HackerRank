package implementations;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/23/17.
 */
public class SavePrisoner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test_cases = in.nextInt();
        for(int i=0;i<test_cases;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            System.out.println((s+m-1)%n==0?n:(s+m-1)%n);
//            int r = m%n;
//            System.out.println(((s-1+r)%n)==0?n:(s-1+r));
        }
    }
}
