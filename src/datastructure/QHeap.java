package datastructure;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/9/17.
 */
public class QHeap {

    private static PriorityQueue<Integer> pQ = new PriorityQueue<>(Integer::compareTo);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int i=0;i<q;i++){
            int op = in.nextInt();
            switch(op){
                case 1:
                    addElement(in.nextInt());
                    break;
                case 2:
                    deleteElement(in.nextInt());
                    break;
                case 3:
                    printMin();
                    break;

            }

        }
    }

    private static void printMin() {
        System.out.println(pQ.peek());
    }

    private static void addElement(int i) {
        pQ.add(Integer.valueOf(i));
    }

    private static void deleteElement(int i) {
        pQ.remove(Integer.valueOf(i));
    }


}
