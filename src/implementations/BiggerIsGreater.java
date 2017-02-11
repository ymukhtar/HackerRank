package implementations;

import java.util.*;

/**
 * Created by yasir_mukhtar on 1/25/17.
 */
public class BiggerIsGreater {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test_cases = Integer.parseInt(in.nextLine());
        for (int i = 0; i < test_cases; i++) {
            String word = in.nextLine();
            String r = nextSeq(word.toCharArray());
            if (word.equals(r))
                System.out.println("no answer");
            else
                System.out.println(r);
        }
    }

    public static String nextSeq(char[] input) {
        int length = input.length;
        int maxFromRight = getMaxFromRight(input);
        if (maxFromRight == -1) {
            return new String(input);
        } else {
            int maxLessThenFirst = 0;
            for (int i = length -1; i>0; i--) {
                if (input[maxFromRight]<input[i]) {
                    maxLessThenFirst = i;
                    break;
                }
            }
            char temp = input[maxFromRight];
            input[maxFromRight] = input[maxLessThenFirst];
            input[maxLessThenFirst] = temp;
            char[] result= new char[maxFromRight+1];
            for(int i=0;i<maxFromRight+1;i++){
                result[i]=input[i];
            }
            StringBuilder sb= new StringBuilder();
            for(int j=maxFromRight+1;j<length;j++){
                sb.append(input[j]);
            }
            return new String(result)+sb.reverse();
        }
    }

    private static int getMaxFromRight(char[] input) {
        int maxFromRight=-1;
        for (int i = input.length-1; i > 0; i--) {
            if (input[i]>input[i - 1]) {
                maxFromRight = i - 1;
                break;
            }
        }
        return maxFromRight;
    }
}
