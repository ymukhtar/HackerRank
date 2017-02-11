package implementations;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/23/17.
 */
public class UtopianTree {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int test_cases = in.nextInt();
        for(int t=0;t<test_cases;t++){
            int height = 1;
            //even spring , odd summer
            int cycles = in.nextInt();
            for(int c =1;c<=cycles; c++){
                height = (c%2!=0)? height*2 : height+1;
            }
            System.out.println(height);
        }
    }
}
