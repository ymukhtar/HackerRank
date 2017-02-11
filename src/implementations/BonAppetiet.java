package implementations;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/23/17.
 */
public class BonAppetiet {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int total_shared_cost=0,t=0;
        for(int i=0;i<n;i++){
            t = in.nextInt();
            if(i != k)
                total_shared_cost+=t;
        }
        int b_charged= in.nextInt();

        if(((total_shared_cost/2) - b_charged) >= 0){
            System.out.println("Bon Appetit");
        }
        else{
            System.out.println( b_charged- (total_shared_cost/2) );
        }

    }
}
