package h101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 2/14/17.
 */
public class LenaSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int len = in.nextInt();
            int c = in.nextInt();
            Integer[] arr = new Integer[len];
            for(int i=1;i<=len;i++){
                arr[i-1] = i;
            }
            List<String> results = new ArrayList<>();
            makePerm1(arr,0,arr.length,results,c);
            if(results.size()>0){
                System.out.println(results.get(0));
                System.out.print("\n");
            }else{
                System.out.println(-1);
            }
        }
    }

    public static class Tuple<T1,T2>{
        T1 t1;
        T2 t2;
        public Tuple(T1 t1, T2 t2) {
            this.t1 = t1;
            this.t2 = t2;
        }
    }

    private static Tuple<List<Integer>,Integer> lena_sort(List<Integer> nums,int old_comp) {
        if (nums.size() <= 1) {
            return new Tuple(nums,0);
        }
        int pivot = nums.get(0);
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        int comparisons =0;
        for (int i = 1; i < nums.size(); ++i) {
            comparisons++;
            if (nums.get(i) < pivot) {
                less.add(nums.get(i));
            }
            else {
                more.add(nums.get(i));
            }
        }
        Tuple<List<Integer>,Integer> sorted_less = lena_sort(less,old_comp);
        sorted_less.t1.add(pivot);
        Tuple<List<Integer>,Integer> sorted_more = lena_sort(more,old_comp);
        sorted_less.t1.addAll(sorted_more.t1);
        return new Tuple(sorted_less.t1,comparisons+sorted_less.t2+sorted_more.t2);
    }

    private static void makePerm1(Integer[] str, int i, int n,List<String> results,int rc) {
        if(results.size()==1){
            return;
        }
        if(i==n){
            Tuple<List<Integer>,Integer> t = lena_sort(Arrays.asList(str),0);
            if(t.t2==rc) {
                StringBuffer sb = new StringBuffer();
                for(Integer t1: str){
                    sb.append(t1).append(" ");
                }
                results.add(sb.toString().trim());
            }
        }else{
            for(int j=i;j<n;j++){
                swap(str,i,j);
                makePerm1(str,i+1,n,results,rc);
                swap(str,i,j);
            }
        }
    }

    private static void swap(Integer[] str, int i, int j) {
        int temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
