package implementations;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/23/17.
 */
public class EnergyClouds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int energy = 100,cloud=0;
        do{
            cloud= (cloud+k)%n;
            energy -= c[cloud] == 1 ? 3: 1;
        }while(cloud!=0);
        System.out.println(energy);
    }
}
