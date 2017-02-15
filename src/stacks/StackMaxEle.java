package stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yasir_mukhtar on 2/11/17.
 */
public class StackMaxEle {
    public static void main(String[] args) {
        MyMaxStack stack = new MyMaxStack();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int op = in.nextInt();
            if(op==1){
                stack.push(in.nextInt());
            }
            else if(op==2){
                stack.pop();
            }
            else{
                System.out.println(stack.max());
            }
        }
    }
    public static class MyMaxStack extends Stack<Integer>{
        private Stack<Integer> max = new Stack<>();
        @Override
        public Integer push(Integer item) {
            if(max.isEmpty() || max.peek() <= item){
                max.push(item);
            }
            return super.push(item);
        }

        @Override
        public synchronized Integer pop() {
            Integer i = super.pop();
            if(max.peek() == i){
                max.pop();
            }
            return i;
        }


        public Integer max() {
            return max.peek();
        }
    }

}
