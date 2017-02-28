package queues;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/20/17.
 */
public class Down2Zero {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        Map<Integer, Integer> num2Steps = new HashMap<>();
        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            Set<Item> visited = new HashSet<>();
            Queue<Item> myQueue = new LinkedList<>();
            myQueue.add(new Item(n, null, 0));
            Item temp;
            int min = Integer.MAX_VALUE;
            while (myQueue.size() > 0) {
                temp = myQueue.remove();
                visited.add(temp);
                if (temp.n == 0) {
                    int steps = 0;
                    while (temp != null) {
                        steps++;
                        temp.stepsToZero= steps;
                        temp = temp.parent;
                    }
                    min = Math.min(min, steps);
                } else {
                    Integer div = findDivisor(temp.n);
                    if (div > 1 && !visited.contains(div))
                        myQueue.add(new Item(div, temp, temp.steps + 1));
                    if (!visited.contains(temp.n - 1) && temp.n - 1 >= 0)
                        myQueue.add(new Item(temp.n - 1, temp, temp.steps + 1));
                }
            }
            num2Steps.put(n, min);
            System.out.println(min);
        }
    }

    private static int getMinFromThis(Set<Item> visited, Integer div) {
        Item tMin=null;
        for(Item tem : visited){
          if(tem.n== div){
              tMin = tem;
              break;
          }
        }
        int minT = tMin.stepsToZero;
        while(tMin!=null){
            minT++;
            tMin = tMin.parent;
        }
        return minT;
    }

    private static int findDivisor(int n) {
        for (int j = (int) Math.floor( Math.sqrt(n)); j >= 2; j--) {
            if (n % j == 0) {
                return Math.max(j, n / j);
            }
        }
        return -1;
    }

    public static class Item {
        public Integer n;
        Item parent;
        int steps;
        int stepsToZero=0;
        public Item(Integer n, Item parent, int s) {
            this.n = n;
            this.parent = parent;
            this.steps = s;
        }
    }
}
