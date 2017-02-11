package crackingcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/2/17.
 */
public class Trie {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ops = in.nextInt();
        Node root = new Node();

        for(int i=0;i<ops;i++){
            String op = in.next();
            String val = in.next();
            if("add".equals(op)){
                root.addChild(val);
            }else{
                Node n = root;
                int isRootComplete = n.isComplete?1:0;
                for(int j=0;j<val.length();j++){
                    n = n.getChildStartingWith(val.charAt(j));
                    if(n==null){
                        break;
                    }
                }
                System.out.println(n==null?0:n.getMyCompleteChildCount()+isRootComplete);
            }
        }
        //System.out.println(root);
    }

    public static class Node{
        private Map<Character,Node> myChildren;
        private boolean isComplete=false;
        int myCompleteChildCount=0;
        private Node parent;

        public Node() {
        }
        public  void incCompletedCounter(){
            ++myCompleteChildCount;
        }

        public boolean isComplete() {
            return isComplete;
        }

        public Node getChildStartingWith(Character ch){
            return myChildren==null?null:myChildren.get(ch);
        }

        public int getMyCompleteChildCount() {
            return myCompleteChildCount;
        }

        public int mySize(){
            int s= this.isComplete==true?1:0;
            if(myChildren!=null) {
                for (Node n : myChildren.values()) {
                    s += n.mySize();
                }
            }
            return s;
        }


        public Node addChild(String value){
            if(myChildren ==null)
                myChildren = new HashMap<>();
            if(value.length()>0) {
                Character ch = value.charAt(0);
                if (value.length() == 1) {
                    isComplete = true;
                    this.incCompletedCounter();
                    Node temp =this.parent;
                    while(temp!=null){
                        temp.incCompletedCounter();
                        temp = temp.parent;
                    }
                }
                if(myChildren.containsKey(ch)){
                    myChildren.get(ch).addChild(value.substring(1));
                }else {
                    String s =value.substring(1);
                    Node t =new Node();
                    t.parent = this;
                    if(s.length()>0){
                        t.addChild(s);
                    }
                    myChildren.put(ch, t);
                }
            }
            return this;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "myChildren=" + myChildren +
                    ", isComplete=" + isComplete +
                    '}';
        }
    }
}
