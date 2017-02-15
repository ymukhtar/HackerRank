package stacks;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/13/17.
 */
public class PoisonousPlant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        LinkedList<Integer> plants = new LinkedList<>();
        Set<Integer> dyingIndex= new TreeSet<>();
        boolean isDying = false;
        for(int p=0;p<n;p++){
            plants.add(in.nextInt());//Pestisides
            if(p>0 && plants.get(p)>plants.get(p-1)){
                dyingIndex.add(p);
                isDying = true;
            }
        }
        int daysCount = 0;
        while (isDying) {
            isDying = false;
            int removeCount =0;
            for(int idx :dyingIndex){
                plants.remove(idx-removeCount);
                removeCount++;
            }
            dyingIndex.clear();
            int size = plants.size();
            if(size!=0)
                daysCount++;
            for(int i=1;i<size;i++){
                int oldIdx=i-1;
                if( plants.get(i)>plants.get(i-1)){
                    dyingIndex.add(i);
                    isDying = true;
                    while(i+1< size &&   plants.get(i+1)>oldIdx){
                        dyingIndex.add(i+1);
                        i++;
                        daysCount++;
                    }
                }
            }
        }
        System.out.println(daysCount);
    }
}
