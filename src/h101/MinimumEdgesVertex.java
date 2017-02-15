package h101;

import graphTheory.SnakesAndLadder;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/13/17.
 */
public class MinimumEdgesVertex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        if(k>n){
            System.out.println("-1");
        }
        else{
            //k is the number of layers
            Graph g = new Graph(k);
            g.addVertex(0, new Vertex(0));
            g.addVertex(k-1, new Vertex(k-1));

            //
            int rVertices = n-2; // from layer 1 to k-2
            int rLayers = k-2;
            int perLayerVert = rVertices/rLayers;
            int last_Layer_vertices = rVertices-perLayerVert*(rLayers-1);
            for(int j=0;j<last_Layer_vertices;j++)
                g.addVertex(k-2,new Vertex(n-last_Layer_vertices-j));
            for(int l=1;l<k-2;l++){
                for(int j=0;j<perLayerVert;j++)
                    g.addVertex(l,new Vertex(l*perLayerVert+1));
            }
            //System.out.println(g.toString());
            System.out.println(g.total_edges());
        }

    }

    public static class Graph{

        Map<Integer,List<Vertex>> myLayers;

        List<Edge> edges;
        int total_Layers =0;

        public Graph(int k ) {
           myLayers = new HashMap<>();
           total_Layers = k;
        }

        public void addVertex(int layer, Vertex v){
            myLayers.putIfAbsent(layer,new ArrayList<>());
            myLayers.get(layer).add(v);
        }

        public int total_edges(){
            int total = 0;
            for(int l =1;l<total_Layers;l++){
                total += myLayers.get(l-1).size()*myLayers.get(l).size();
            }
            return total;
        }

        @Override
        public String toString() {
            return "Graph{" +
                    "myLayers=" + myLayers +
                    ", edges=" + edges +
                    ", total_Layers=" + total_Layers +
                    '}';
        }
    }

    public static class Vertex{
        int data;
        List<Edge> edgeList;

        public Vertex(int data) {
            this.data = data;
        }
    }

    public static class Edge{
        Vertex source;
        Vertex dest;

    }
}
