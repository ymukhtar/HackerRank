package implementations;

import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/24/17.
 */
public class AppendAndDelete {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        if(s.length()<t.length() && t.length()-s.length()==k){
            System.out.println("Yes");
        }
        else{
            int matchIndex=0;
            for(int i=0;i<Math.min(s.length(),t.length());i++){
                if(s.charAt(i)==t.charAt(i)){
                    matchIndex++;
                }
                else{
                    break;
                }
            }
            int to_delete = t.length()-matchIndex;
            int to_append = s.length()-matchIndex;
            if(k-to_delete<to_append){
                System.out.println("No");
            }
            else if(k-s.length()>=t.length()){
                System.out.println("Yes");
            }
            else if((k-to_append-to_delete)%2==0){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }

        }
    }
}
