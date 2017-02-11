package DynamicProgramming;

import java.util.*;

/**
 * Created by yasir_mukhtar on 1/30/17.
 */
public class CoinChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() , m = in.nextInt();
        int[] coin_store = new int[m];
        for(int i=0;i<m;i++){
            coin_store[i] = in.nextInt();
        }
        MyArraySet comb = new MyArraySet();
        // Sample W.R.
        find_subarray_sum(coin_store,n,new ArrayList<>(),comb);
        System.out.println(comb.toString());
        System.out.println(comb.size());
    }

    public static void find_subarray_sum(int[] store, int target, List<Integer> partial,MyArraySet comb){
        //System.out.println(partial);
        int sum = partial.stream().mapToInt(v -> Integer.valueOf(v)).sum();
        if(sum ==target){
            //System.out.println(partial);
            if(!comb.contains(partial))
                comb.add(partial);
            return ;
        }
        else if(sum>target){
            return;
        }
        else if(store.length==0){
            return;
        }
        else{
            for(int i=0;i<store.length;i++){
                List<Integer> myList = new ArrayList<>(partial);
                myList.add(store[i]);
                find_subarray_sum(store,target,myList,comb);
            }
        }
    }

    static class MyArraySet{
        private Set<List<Integer>> mySet = new HashSet<>();

        public void add(List<Integer> val){
            Collections.sort(val);
            mySet.add(val);
        }
        public boolean contains(List<Integer> it){
            return mySet.contains(it);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyArraySet that = (MyArraySet) o;

            return mySet != null ? mySet.equals(that.mySet) : that.mySet == null;
        }

        @Override
        public int hashCode() {
            return mySet != null ? mySet.hashCode() : 0;
        }
        public int size(){
            return mySet.size();
        }

        @Override
        public String toString() {
            return "MyArraySet{" +
                    "mySet=" + mySet +
                    '}';
        }
    }
}
