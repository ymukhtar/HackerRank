package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/20/17.
 */
public class D2Z {
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            Queue<MyQEntry> myQ = new LinkedList<>();
            myQ.add(new MyQEntry(n,null,0));
            int min = Integer.MAX_VALUE;
            boolean vis[]=new boolean[n+1];

            while(!myQ.isEmpty()) {
                MyQEntry t = myQ.remove();
                if (!vis[t.v]) {
                    vis[t.v] = true;
                    if (t.v == 0) {
                        min = Math.min(min, t.steps);
                        break;
                    }
                    for (int j = (int) Math.ceil(Math.sqrt(t.v)); j >= 2; j--) {
                        if (t.v % j == 0 ) {
                            myQ.add(new MyQEntry(Math.max(j, t.v / j), t, t.steps + 1));
                        }
                    }
                    if (t.v - 1 >= 0 ) {
                        myQ.add(new MyQEntry(t.v - 1, t, t.steps + 1));
                    }
                }
            }
            System.out.println(min);
        }

        //System.out.println("finished");
    }

    public static class MyQEntry{
        Integer v;
        MyQEntry parent;
        int steps;
        public MyQEntry(Integer v, MyQEntry parent,int steps) {
            this.v = v;
            this.parent = parent;
            this.steps = steps;
        }
    }
}
