package strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/1/17.
 */
public class BeautifulString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count =0;

        String str = in.next();
        for(int i=1;i<n-1;){
          if(str.charAt(i-1)=='0'&& str.charAt(i)=='1' && str.charAt(i+1)=='0'){
              count++;
              i+=2;
          }
          else
              i++;
        }
        System.out.println(count);
    }
}
