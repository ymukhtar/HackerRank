package implementations;

import java.util.Scanner;



/**
 * Created by yasir_mukhtar on 1/23/17.
 */
public class BeautifulDays {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        long i = in.nextLong(), j = in.nextLong(), k = in.nextLong(), total_beautiful=0;
//        for(long day=i;day<=j;day++){
//            if((day-reverse(day))%k==0)
//                total_beautiful++;
//        }
//        System.out.println(total_beautiful);
        long t = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            reverse(i);
        }
        System.out.println("Time : "+ (System.nanoTime()-t )+" ns");
    }

    private static int reverse(int day) {
        char[] digits =Integer.valueOf(day).toString().toCharArray();
        char[] reversed = new char[digits.length];
        int total_digits = digits.length;
        for(int i= 0;i<total_digits;i++){
            reversed[i]=digits[total_digits-i-1];
        }
        return Integer.parseInt(new String(reversed));
    }
}
