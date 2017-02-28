package h101;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/14/17.
 */
public class DNA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long startTime = System.currentTimeMillis();
        TrieNode root = new TrieNode();
        for (int genes_i = 0; genes_i < n; genes_i++) {
            root.add(in.next().toCharArray(),genes_i);
        }
        int[] health = new int[n];
        for (int health_i = 0; health_i < n; health_i++) {
            health[health_i] = in.nextInt();
        }
        //System.out.println(root);
        long total_health, max_health = Long.MIN_VALUE, min_health = Long.MAX_VALUE;
        int s = in.nextInt();
        int j,key;
        TrieNode tn;
        int length;
        String d;
        int first,last,i;
        for (int a0 = 0; a0 < s; a0++) {
            first = in.nextInt();
            last = in.nextInt();
            d= in.next();
            length = d.length();
            total_health = 0;
            // your code goes here
            for (i = 0; i < length; i++) {
                key = d.charAt(i)-'a';
                if(root.children[key]==null)
                    continue;
                tn = root.children[key];
                j=i;
                while(tn!=null && j< length){
                    if(tn.isComplete) {
                        for (int idx : tn.idxList) {
                            if (idx >= first && idx <= last) {
                                total_health += health[idx];
                            }
                        }
                    }
                    tn = (++j< length)?tn.children[d.charAt(j)-'a']:null;
                }
            }
            max_health = Math.max(total_health, max_health);
            min_health = Math.min(total_health, min_health);
        }
        System.out.printf("%d %d\n", min_health, max_health);
        System.out.println((System.currentTimeMillis()-startTime)/1000.0);
    }

    public static class TrieNode {
        boolean isComplete = false;
        TrieNode[] children;
        private ArrayDeque<Integer> idxList=null;
        public TrieNode() {
            children = new TrieNode[26];
        }

        public void add(char str[],int idx) {
            TrieNode tn = this;
            int sIdx=0,key;
            for(char ch :str) {
                key = ch-'a';
                if (tn.children[key]==null)
                    tn.children[key]= new TrieNode();
                tn = tn.children[key];
                if (str.length - 1 == sIdx++) {
                    tn.isComplete = true;
                    if (tn.idxList == null) {
                        tn.idxList = new ArrayDeque<>();
                    }
                    tn.idxList.add(idx);
                }
            }
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "isComplete=" + isComplete +
                    ", children=" + children +
                    ", idxList=" + idxList +
                    '}';
        }
    }
}
