package implementations;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/23/17.
 */
public class ViralAdvertisement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double total_liked =findLikes(Math.floor(5/2),n);
        System.out.println((int)total_liked);

    }

    private static double findLikes(double likes,  Integer n) {
        if(n ==1)
            return likes;
        return likes+ findLikes(Math.floor(likes*3/2),n-1);
    }
}
