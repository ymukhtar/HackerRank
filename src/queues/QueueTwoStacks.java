package queues;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yasir_mukhtar on 2/16/17.
 */
public class QueueTwoStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        Scanner in = new Scanner(System.in);
        int tQ= in.nextInt();
        int op;
        for(int q=0;q<tQ;q++){
            op = in.nextInt();
            if(op==1)
                queue.enQueue(in.nextInt());
            else if(op==2)
                queue.deQueue();
            else
                System.out.println( queue.peek());
           // System.out.println(queue);
        }
    }

    public static class MyQueue{
        private Stack<Integer> input = new Stack<>();
        private Stack<Integer> output = new Stack<>();

        public void enQueue(int n){
            input.push(n);
        }

        public int deQueue(){
            if(output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.pop();
        }
        public int peek(){
            if(output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        @Override
        public String toString() {
            return "MyQueue{" +
                    "input=" + input +
                    ", output=" + output +
                    '}';
        }
    }
}
