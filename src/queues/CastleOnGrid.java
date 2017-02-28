package queues;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/20/17.
 */
public class CastleOnGrid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[][] matrix = new Integer[n][n];
        Integer[][] visited = new Integer[n][n];
        for(int r=0;r<n;r++){
            String row = in.next();
            for(int ch=0; ch<row.length();ch++) {
                matrix[r][ch] = (row.charAt(ch) == '.' ? 1 : 0);
                visited[r][ch] =0;
            }
        }
       // printMatrix(matrix);
        int sr = in.nextInt() , sc = in.nextInt(), destr = in.nextInt(), destc = in.nextInt();
        int[] r = {0,-1,0,1};
        int[] c= {-1,0,1,0};
        int minimum_step = Integer.MAX_VALUE;
        Queue<Position> myPositionQueue = new PriorityQueue<>(Comparator.comparing(o -> o.distanceFromParent));
        myPositionQueue.add(new Position(sr,sc,null,0));
        while(myPositionQueue.size()>0){
            Position p = myPositionQueue.remove();
            visited[p.r][p.c] =1;
            for(int d=0;d<r.length;d++){
               int dr=r[d],dc = c[d];
               int nextr = p.r+dr, nextc = p.c+dc;
                while(nextr>=0&&nextr<n && nextc>=0 && nextc<n && matrix[nextr][nextc] ==1 && visited[nextr][nextc]==0){
                   if(nextr==destr && nextc == destc){
                       int steps = 1;
                       while(p.parent!=null){
                           steps++;
                           p = p.parent;
                       }
                       minimum_step = Math.min(minimum_step,steps);
                       System.out.println(minimum_step);
                       return;
                   }
                   else{
                       Position pt = new Position(nextr,nextc,p,p.distanceFromParent+1);
                       if(visited[pt.r][pt.c]==0) {
                           myPositionQueue.add(pt);
                       }
                   }
                    nextr+=dr;
                    nextc+=dc;
               }
            }
        }
    }

    private static void printMatrix(Integer[][] matrix) {
        for(int r=0;r<matrix[0].length;r++){
            System.out.println(Arrays.toString(matrix[r]));
        }
    }

    public static  class Position{
        int r,c;
        Position parent;
        Integer distanceFromParent=0;

        public Position(int r, int c, Position parent,int d) {
            this.r = r;
            this.c = c;
            this.parent = parent;
            this.distanceFromParent = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (r != position.r) return false;
            return c == position.c;
        }

        @Override
        public int hashCode() {
            int result = r;
            result = 31 * result + c;
            return result;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "r=" + r +
                    ", c=" + c +
                    ", parent=" + parent +
                    ", distance=" + distanceFromParent +
                    '}';
        }
    }
}
