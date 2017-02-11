package implementations;

import java.util.Arrays;
import java.util.Scanner;

public class AbsPermutations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] perm = new int[n];
            for (int i = 0; i < n; i++) {
                perm[i] = i + 1;
            }
            if (k == 0) {
                printArray(perm);
            } else if(n%(2*k)==0) {
                for (int i = 0; i < (n / (2 * k)); i++) {
                    for (int j = 0; j < k; j++) {
                        int temp = perm[i * 2 * k + j];
                        perm[i * 2 * k + j] = perm[i * 2 * k + k + j];
                        perm[i * 2 * k + k + j] = temp;
                    }
                }
                printArray(perm);
            }
            else
                System.out.println(-1);
        }
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
