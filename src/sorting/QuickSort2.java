package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/29/17.
 */
public class QuickSort2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        List<Integer> ar = new ArrayList<>(s);
        for(int i=0;i<s;i++){
            ar.add(in.nextInt());
        }
        List<Integer> sorted = quickSort(new ArrayList<>(ar));
//        for(int item:sorted)
//            System.out.print(item+" ");
    }

    private static List<Integer> quickSort(List<Integer> ar) {
        if(ar.size()<=1)
            return ar;

        int pivot = ar.get(0);
        List<Integer> equal = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int j=0;j<ar.size();j++){
            Integer e = ar.get(j);
            if(e ==pivot){
                equal.add(e);
            }else if(e <pivot){
                left.add(e);
            }else{
                right.add(e);
            }
        }
        return merge(quickSort(left),equal,quickSort(right));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> equal, List<Integer> right) {
        left.addAll(equal);
        left.addAll(right);
        for(int item:left)
            System.out.print(item+" ");
        System.out.println("");
        return left;
    }
}
