package strings;

import java.util.Scanner;



/**
 * Created by yasir_mukhtar on 1/28/17.
 */
public class MarsExploration {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int total_different =0;
        for(int i=0;i<s.length();i+=3){
            total_different+=compare("SOS",s.substring(i,i+3));
        }
        System.out.println(total_different);
    }

    private static int compare(String s1,String s2){
        int diff =0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                diff++;
        }
        return diff;
    }

}
