package crackingcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yasir_mukhtar on 2/26/17.
 */
public class Brackets {
    public static boolean isBalanced(String expression) {
        Stack<Character> opened_brakets = new Stack<>();
        for(char ch : expression.toCharArray()){
            if(ch =='(' || ch =='[' || ch =='{'){
                opened_brakets.push(ch);
            }
            else{
                if(opened_brakets.isEmpty() || convert(ch) != opened_brakets.pop())
                    return false;
            }
        }
        return opened_brakets.isEmpty();
    }

    private static Character convert(char ch) {
        if(ch==')')
            return '(';
        else if(ch==']')
            return '[';
        else
            return '{';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
