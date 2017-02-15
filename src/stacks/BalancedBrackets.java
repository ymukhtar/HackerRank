package stacks;

import java.util.Scanner;
import java.util.Stack;



/**
 * Created by yasir_mukhtar on 2/11/17.
 */
public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            Stack<Character> openedBrackets = new Stack<>();
            char[] brackets= in.next().toCharArray();
            int j=0;
            for(;j<brackets.length;j++){
                //System.out.println(brackets[j]+"-->"+openedBrackets.toString());
                if(isOpeningBracket(brackets[j])){
                    openedBrackets.push(brackets[j]);
                }
                else{
                    //System.out.println(""+temp+","+brackets[j]);
                    if(openedBrackets.isEmpty() || !matchBrackets(openedBrackets.pop()  , brackets[j])){
                        break;
                    }
                }
            }
            if(!openedBrackets.isEmpty() || j!= brackets.length){
                System.out.println("NO");
            }
            else
                System.out.println("YES");

        }
    }

    private static boolean matchBrackets(char stackChar, char bracket) {
        switch (stackChar){
            case '(':
                return bracket==')';
            case '[':
                return bracket==']';
            case '{':
                return bracket=='}';
        }
        return false;
    }

    private static boolean isOpeningBracket(char bracket) {
        return bracket == '[' || bracket =='(' || bracket =='{';
    }

    private static boolean isClosingBracket(char bracket) {
        return bracket == ']' || bracket =='}' || bracket ==')';
    }
}
