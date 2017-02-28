package crackingcode;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/27/17.
 */
public class BFS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        for(int q=0;q<queries;q++){
            Graph g = new Graph();
            int n = in.nextInt(), m = in.nextInt(),u,v;
            for(int i=0;i<n;i++){
                g.createNode(i+1);
            }
            for(int j=0;j<m;j++){
                g.addEdge(in.nextInt(),in.nextInt());
            }
            int s = in.nextInt();
            g.BFS(s,n);
        }
    }

    public static class Node{
        int nodeId;
        LinkedList<Node> adjacent = new LinkedList<>();

        public Node(int nodeId) {
            this.nodeId = nodeId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return nodeId == node.nodeId;
        }

        @Override
        public int hashCode() {
            return nodeId;
        }
    }

    public static class Graph{
        Map<Integer,Node> nodeLookup = new LinkedHashMap<>();

        public void addEdge(int source,int destination){
            Node s = getNode(source);
            Node d = getNode(destination);
            s.adjacent.add(d);
            d.adjacent.add(s);
        }
        public void createNode(int id){
            nodeLookup.put(id,new Node(id));
        }

        public Node getNode(int id) {
            return nodeLookup.get(id);
        }

        public void BFS(int start,int size){
            int[] distances = new int[size+1];
            Arrays.fill(distances,-1);
            LinkedList<Node> queue = new LinkedList<>();
            Node cur;
            cur = getNode(start);
            distances[cur.nodeId] =0;
            queue.add(cur);
            while(!queue.isEmpty()){
                cur = queue.remove();
                for(Node  n : cur.adjacent){
                    if(distances[n.nodeId] ==-1) {
                        distances[n.nodeId] = distances[cur.nodeId] +6;
                        queue.add(n);
                    }
                }
            }
            for(int i=1;i<=size;i++){
                if(i!=start)
                    System.out.print(distances[i]+" ");
            }
            System.out.println();
        }
    }
}
