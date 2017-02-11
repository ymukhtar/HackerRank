package implementations;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/23/17.
 */
public class FindDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test_cases = in.nextInt();
        for(int t=0;t<test_cases;t++){
            long org = in.nextLong(),total_div=0;
            long n = org;
            while(n!=0){
                int r = (int)n%10;
                if(r!=0)
                    total_div += (org%r == 0) ? 1:0;
                n = n/10;
            }
            System.out.println(total_div);
        }
    }
}
