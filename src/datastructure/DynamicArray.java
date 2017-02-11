package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/2/17.
 */
public class DynamicArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), q = in.nextInt();
        List<List<Integer>> seqList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }
        int lastAns = 0;
        for (int i = 0; i < q; i++) {
            int type = in.nextInt(), x = in.nextInt(), y = in.nextInt();
            if (type == 1) {
                int idx = ((x ^ lastAns) % n);
                List<Integer> seq = seqList.get(idx);
                seq.add(y);
            } else {
                int idx = ((x ^ lastAns) % n);
                List<Integer> seq = seqList.get(idx);
                lastAns = seq.get(y % seq.size());
                System.out.println(lastAns);
            }
        }

    }
}
