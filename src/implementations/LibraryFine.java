package implementations;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/24/17.
 */
public class LibraryFine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a_d= in.nextInt(), a_m=in.nextInt(), a_y = in.nextInt();
        int e_d= in.nextInt(), e_m=in.nextInt(), e_y = in.nextInt();
        Calendar actual = Calendar.getInstance();
        actual.set(Calendar.MONTH,a_m-1);
        actual.set(Calendar.DAY_OF_MONTH,a_d-1);
        actual.set(Calendar.YEAR,a_y-1);
        Calendar expected = Calendar.getInstance();
        expected.set(Calendar.MONTH,e_m-1);
        expected.set(Calendar.DAY_OF_MONTH,e_d-1);
        expected.set(Calendar.YEAR,e_y-1);

        if(actual.before(expected)){
            System.out.println(0);
        }
        else if(e_y<a_y)
            System.out.println(10000);
        else if(e_m<a_m)
            System.out.println(500*(a_m-e_m));
        else if(e_d<a_d)
            System.out.println(15*(a_d-e_d));
        else
            System.out.println(0);

    }
}
