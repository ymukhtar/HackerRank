package implementations;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/24/17.
 */
public class SherlockAndSquares {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test_cases = in.nextInt();
        for (int t = 0; t < test_cases; t++) {
            int min = in.nextInt(), max = in.nextInt();
            int squares = 0;
            int oldSq = 1;
            int n = 1;
            int square = 1;
            while (square <= max) {
                if (square >= min && square <= max) {
                    squares++;
                }
                square = 2 * n + 1 + oldSq;
                n++;
                oldSq = square;
            }
            System.out.println(squares);
        }
    }
}
