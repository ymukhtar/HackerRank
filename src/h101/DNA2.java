package h101;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/15/17.
 */
public class DNA2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long startTime = System.currentTimeMillis();
        Map<String, List<Integer>> genesMap = new HashMap<>(n);
        String gene;
        for (int genes_i = 0; genes_i < n; genes_i++) {
            gene = in.next();
            if (!genesMap.containsKey(gene))
                genesMap.put(gene, new ArrayList<Integer>());
            genesMap.get(gene).add(genes_i);
        }
        int[] health = new int[n];
        for (int health_i = 0; health_i < n; health_i++) {
            health[health_i] = in.nextInt();
        }
        long total_health, max_health = Long.MIN_VALUE, min_health = Long.MAX_VALUE;
        int s = in.nextInt();
        String stra;
        List<Integer> idxList;
        String d;
        int length;
        int first, last;
        for (int a0 = 0; a0 < s; a0++) {
            first = in.nextInt();
            last = in.nextInt();
            d = in.next();
            total_health = 0;
            // your code goes here
            length = d.length();
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j <= length; j++) {
                    stra = d.substring(i, j);
                    idxList = genesMap.get(stra);
                    if (idxList != null) {
                        for (int idx : idxList) {
                            if (idx >= first && idx <= last) {
                                total_health += health[idx];
                            }
                        }
                    }
                }
            }
            max_health = Math.max(total_health, max_health);
            min_health = Math.min(total_health, min_health);
        }
        System.out.printf("%d %d\n", min_health, max_health);
        System.out.println((System.currentTimeMillis()-startTime)/1000.0);
    }
}
