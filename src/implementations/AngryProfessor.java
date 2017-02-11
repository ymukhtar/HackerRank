package implementations;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/23/17.
 */
public class AngryProfessor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test_cases = in.nextInt();
        for(int t=0;t<test_cases;t++){
            int n = in.nextInt();
            int k = in.nextInt();
            int total_on_time =0;

            for(int i =0;i<n; i++){
                total_on_time += (in.nextInt()<=0) ? 1:0;
            }
            if(total_on_time>=k) {
                System.out.println("NO");
            }
            else
                System.out.println("YES");
        }
    }
}
