package stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yasir_mukhtar on 2/12/17.
 */
public class TextEditor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<String> ops = new Stack<>();
        StringBuffer s = new StringBuffer();
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int op = in.nextInt();
            switch (op){
                case 1:
                    //Add
                    ops.push(s.toString());
                    s.append(in.next());
                    //System.out.println("1--"+s);

                    break;
                case 2:
                    ops.push(s.toString());
                    s = new StringBuffer(s.substring(0,s.length()-in.nextInt()));
                   // System.out.println("2--"+s);
                    break;
                case 3:
                    System.out.println(s.charAt(in.nextInt()-1));
                    break;
                case 4:
                    if(!ops.isEmpty())
                        s = new StringBuffer(ops.pop());
            }
        }

    }
}
