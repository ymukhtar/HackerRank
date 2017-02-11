package graphTheory;

import java.util.*;

/**
 * Created by yasir_mukhtar on 1/27/17.
 */
public class EvenTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        Node root = new Node(1);
        for(int e=0;e<m;e++){
            int c= in.nextInt(),p=in.nextInt();
            root.addChildren(new Node(c),p);
        }
        //System.out.println(root);
        //bfs(root);
        chopTrees(root);
    }

    private static void chopTrees(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addAll(root.children);
        int to_remove =0;
        while(queue.size()!=0){
            Node me = queue.removeFirst();
           if(me.weight%2!=0){
               me.parent.removeChild(me);
               to_remove++;
           }
            queue.addAll(me.children);
        }
        System.out.println(to_remove);
    }

    private static void bfs(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()!=0){
            Node me = queue.removeFirst();
            System.out.println(me.value+" weight:"+me.weight+" level:"+me.level+" parent:"+(me.parent==null?"":me.parent.value));
            queue.addAll(me.children);
        }
    }

    public  static class Node{
        int value;
        List<Node> children;
        int weight=0;
        Node parent;
        int level=0;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            return value;
        }

        public Node(int v) {
            this.value = v;
            children = new ArrayList<>();
            weight=0;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void addChildren(Node child,int source) {
            if(this.value == source){
                this.children.add(child);
                child.parent = this;
                child.level = this.level+1;
                this.weight+=1;
                //propagate weight
                Node temp = this.parent;
                while(temp!=null){
                    temp.weight += 1;
                    temp = temp.parent;
                }

            }else{
                if(children.size()>0) {
                    for (Node n : children) {
                        n.addChildren(child,source);
                    }
                }
            }
        }


        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", children=" + children +
                    ", weight=" + weight +
                    '}';
        }

        public void removeChild(Node me) {
            this.weight-=me.weight;
            this.children.remove(me);
        }
    }

}
