package datastructure;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by yasir_mukhtar on 2/10/17.
 */
public class SwapBT {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes = in.nextInt();
        Node  root = new Node(1,1);
        Queue<Node> insertOrder = new LinkedList<>();
        insertOrder.add(root);
        for(int i=0;i<nodes;i++){
            int left = in.nextInt(), right = in.nextInt();
            Node n = insertOrder.remove();
            if(left != -1){
                n.left = new Node(left,n.depth+1);
                insertOrder.add(n.left);
            }
            if(right != -1){
                n.right = new Node(right,n.depth+1);
                insertOrder.add(n.right);
            }
        }
        int heig = height(root);

       // System.out.println(root);
        int cases = in.nextInt();
        for(int c =0 ;c<cases;c++){
            int k = in.nextInt();
            for(int h = 1; h<=heig;h++ ) {
                swapAtK(root, k*h);
            }
            inOrder(root);
            System.out.print("\n");
        }
    }

    private static int height(Node root){
        if(root==null)
            return 0;
        else
            return 1+Math.max(height(root.left),height(root.right));
    }

    private static void swapAtK(Node node, int k) {
        if(node==null){
            return;
        }
        if(node.depth == k){
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        else{
            if(node.left!=null)
                swapAtK(node.left,k);
            if(node.right!=null)
                swapAtK(node.right,k);
        }
    }

    public  static void inOrder(Node root){
        if(root.left!=null)
            inOrder(root.left);
        System.out.print(root.value+" ");
        if(root.right!=null)
            inOrder(root.right);
    }

    public static class Node{
        int value;
        Node left;
        Node right;
        int depth;

        public Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", depth="+depth+
                    ", left=" + (left==null?"-1":left) +
                    ", right=" + (right==null?"-1":right) +
                    "}";
        }
    }
}
