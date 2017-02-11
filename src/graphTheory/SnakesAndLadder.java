package graphTheory;

import java.util.*;

/**
 * Created by yasir_mukhtar on 1/28/17.
 */
public class SnakesAndLadder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int test_case = in.nextInt();
        for(int t=0;t<test_case;t++){
            boolean[] visited = new boolean[101];
            int[] moves = new int[101];
            Arrays.fill(moves,-1);
            int l = in.nextInt();
            for(int i=0;i<l;i++){
                moves[in.nextInt()] = in.nextInt();
            }
            int s = in.nextInt();
            for(int i=0;i<s;i++){
                moves[in.nextInt()] = in.nextInt();
            }
            //Ladded and snake jumps are added.
            LinkedList<Vertex> queue = new LinkedList<>();
            queue.add(new Vertex(1,0));//start from 1
            Vertex v=null;
            while (!queue.isEmpty()){
                 v = queue.remove();
                if(v.getValue()==100)
                    break;
                for(int j=(v.getValue()+1);j<=(v.getValue()+6) && j<101;j++){
                    if(!visited[j]){
                        visited[j] = true;
                        Vertex tV = new Vertex(j,v.dist+1);
                         if(moves[j]!=-1)
                             tV.setValue(moves[j]);
                         queue.add(tV);
                    }
                }
            }
            if(v!=null && v.getValue()==100)
                System.out.println(v.getDist());
            else
                System.out.println(-1);
        }

    }
    public static class Vertex{
        int value;
        int dist;

        public Vertex(int value,int d) {
            this.value = value;
            this.dist=d;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }
    }
}
