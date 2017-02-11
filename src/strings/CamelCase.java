package strings;

import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by yasir_mukhtar on 1/28/17.
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int total_words =1;
        for(char c:s.toCharArray()){
            if(c>='A' && c<='Z')
                total_words++;
        }
        System.out.println(total_words);
    }
}
