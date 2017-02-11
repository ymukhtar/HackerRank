package strings;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/30/17.
 */
public class JohnString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int k = 0; k < t; k++) {
            String j1 = in.next()+'z';
            String j2 = in.next()+'z';
            StringBuilder out = new StringBuilder();
            int s1Index = 0, s2Index = 0, length1 = j1.length(), length2 = j2.length();
            for (; s1Index < length1 && s2Index < length2; ) {
                if(j1.charAt(s1Index)!=j2.charAt(s2Index)){
                    if(j1.charAt(s1Index)<=j2.charAt(s2Index)){
                        out.append(j1.charAt(s1Index++));
                    }else{
                        out.append(j2.charAt(s2Index++));
                    }
                }
                else {
                    if (myCompareTo(j1, j2, s1Index, s2Index, length1, length2) <= 0) {
                        out.append(j1.charAt(s1Index++));
                        char ch = j1.charAt(s1Index - 1);
                        while (s1Index < length1 && ch == j1.charAt(s1Index))
                            out.append(j1.charAt(s1Index++));
                    } else {
                        out.append(j2.charAt(s2Index++));
                        char ch = j2.charAt(s2Index - 1);
                        while (s2Index < length2 && ch == j2.charAt(s2Index))
                            out.append(j2.charAt(s2Index++));
                    }
                }
            }
            if (s1Index < length1)
                out.append(j1.substring(s1Index));
            if (s2Index < length2)
                out.append(j2.substring(s2Index));
            System.out.println(out.substring(0,out.length()-2));
        }
    }

    private static int myCompareTo(String j1, String j2, int s1Index, int s2Index, int length1, int length2) {
        int len1 = length1 - s1Index;
        int len2 = length2 - s2Index;
        int lim = Math.min(len1, len2);
        int k = 0;
        while (k < lim) {
            if (j1.charAt(k + s1Index) != j2.charAt(k + s2Index)) {
                return j1.charAt(k + s1Index) - j2.charAt(k + s2Index);
            }
            k++;
        }
        return len1 - len2;
    }
}