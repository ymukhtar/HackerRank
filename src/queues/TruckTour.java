package queues;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/21/17.
 */
public class TruckTour {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Graph g = new Graph(n);
        Vertex v0 = new Vertex(0, in.nextInt(), in.nextInt());
        g.addVertex(v0);
        Vertex prev = v0, newV = null;
        for (int i = 1; i < n; i++) {
            newV = new Vertex(i, in.nextInt(), in.nextInt());
            g.addVertex(newV);
            prev.next = newV;
            prev = newV;
        }
        newV.next = v0;
        //g.print();
        for (Vertex v : g.vertices) {
            if (v.availablePetrol >= v.distanceToNext) {
                //System.out.println("Starting at :"+v.pumpNo);
                Queue<Vertex> q = new LinkedList<>();
                q.add(v);
                if (completesCycle(q, v, n)) {
                    System.out.println(g.vertices.indexOf(v));
                    break;
                }
            }
        }

    }

    private static boolean completesCycle(Queue<Vertex> q, Vertex s, int n) {
        int petrolAcc = 0;
        boolean[] visited = new boolean[n];
        Vertex v;
        while (q.size() > 0) {
            v = q.remove();
            if (visited[v.pumpNo] == true) {
                if (petrolAcc > 0) {
                    return true;
                }
                return false;
            }
            visited[v.pumpNo] = true;
            petrolAcc += (v.availablePetrol - v.distanceToNext);
            if(petrolAcc<=0)
                return false;
            q.add(v.next);
        }
        return false;
    }

    public static class Graph {
        List<Vertex> vertices;

        public Graph(int n) {
            vertices = new ArrayList<>(n);
        }

        public void addVertex(Vertex v) {
            this.vertices.add(v);
        }

        public void print() {
            for (Vertex v : vertices)
                System.out.println(v.toString());
        }
    }

    public static class Vertex {
        int pumpNo;
        int availablePetrol;
        int distanceToNext;
        Vertex next;

        public Vertex(int pumpNo, int availablePetrol, int distanceToNext) {
            this.pumpNo = pumpNo;
            this.availablePetrol = availablePetrol;
            this.distanceToNext = distanceToNext;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "pumpNo=" + pumpNo +
                    ", availablePetrol=" + availablePetrol +
                    ", distanceToNext=" + distanceToNext +
                    ", next=" + next.pumpNo +
                    '}';
        }
    }
}
