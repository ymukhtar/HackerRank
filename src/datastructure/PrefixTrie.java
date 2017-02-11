package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/8/17.
 */
public class PrefixTrie {
    public static void main(String[] args) {
        Node trie = new Node();
        trie.value ='*';
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        boolean isBad=false;
        for(int i=0;i<t;i++){
            String nStr= in.next();
            trie.addString(nStr,nStr);
        }
        if(!isBad)
            System.out.println("GOOD SET");
    }

    public static class Node{
        char value;
        boolean isComplete=false;
        Map<Character,Node> edges = new HashMap<>();

        public boolean addString(String str,String org){
            Character ch = str.charAt(0);
            String rem = str.substring(1);
            if(edges.containsKey(ch)){
                Node n= edges.get(ch);
                if(rem.isEmpty()){
                    if(n.edges.size()!=0 || n.isComplete == true){
                        System.out.println("BAD SET");
                        System.out.println(org);
                        System.exit(0);
                    }
                    n.isComplete= true;
                }
                else {
                    if(n.isComplete){
                        System.out.println("BAD SET");
                        System.out.println(org);
                        System.exit(0);
                    }
                    n.addString(rem,org);
                }
            }
            else{
                Node n = new Node();
                if(rem.length()>0)
                    n.addString(rem,org);
                else
                    n.isComplete = true;
                edges.put(ch,n);
            }
            return true;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", isComplete=" + isComplete +
                    ", edges=" + edges +
                    '}';
        }
    }
}
