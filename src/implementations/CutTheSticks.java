package implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by yasir_mukhtar on 1/24/17.
 */
public class CutTheSticks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        List<Integer> sticks= new ArrayList<>(n);
        int t=0;
        for(int i=0;i<n;i++){
            t = in.nextInt();
            if(t!=0) {
                sticks.add(t);
            }
        }
        int cuts=0;
        while(sticks.size()!=0){
            System.out.println(sticks.size());
            final int c_min= sticks.stream().min((Integer a, Integer b)->a.compareTo(b)).get();
            sticks = sticks.stream().mapToInt(v->v-c_min).filter(v->v>0).boxed().collect(Collectors.toList());
        }

    }
}
