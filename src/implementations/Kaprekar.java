package implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/26/17.
 */
public class Kaprekar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int q = in.nextInt();
        Tuple<Integer> t;
        List<Integer> k = new ArrayList<>();
        for(int i=p;i<=q;i++){
            t=getLRofSquare(i);
            if(t.getT1()+t.getT2()==i){
                k.add(i);
            }
        }
        if(k.size()==0)
            System.out.println("INVALID RANGE");
        else
        {
            StringBuilder output = new StringBuilder();
            for(Integer i : k){
                output.append(i).append(" ");
            }
            System.out.println(output.toString().trim());
        }
    }

    private static Tuple<Integer> getLRofSquare(long num) {
        String numStr = String.valueOf(num*num);
        int length = numStr.length();
        String left = numStr.substring(0, length/2);
        String right = numStr.substring(length/2, length);
        return new Tuple<Integer>(left.isEmpty()?0:Integer.parseInt(left),right.isEmpty()?0:Integer.parseInt(right));
    }

    public static class Tuple<T> {
        private T t1,t2;

        public Tuple(T t1, T t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        public Tuple(T t1) {
            this.t1 = t1;
        }

        public T getT1() {
            return t1;
        }

        public void setT1(T t1) {
            this.t1 = t1;
        }

        public T getT2() {
            return t2;
        }

        public void setT2(T t2) {
            this.t2 = t2;
        }
    }

}
