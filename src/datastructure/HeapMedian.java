package datastructure;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/9/17.
 */
public class HeapMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> myList = new SortedArrayList<>();
        for(int i=0;i<n;i++){
            myList.add(in.nextInt());
            if(myList.size()%2==0){
                int mIdx = myList.size() / 2;
                Integer[] arr = myList.toArray(new Integer[]{});
                System.out.printf("%.1f\n", (arr[mIdx-1] + arr[mIdx]) / 2.0f);
            }
            else{
                int mIdx = myList.size()/2;
                Integer[] arr = myList.toArray(new Integer[]{});
                System.out.printf("%.1f\n", (float)arr[mIdx]);
            }
        }
    }

    static class SortedArrayList<T> extends ArrayList<T> {

        @SuppressWarnings("unchecked")
        public void insertSorted(T value) {
            add(value);
            Comparable<T> cmp = (Comparable<T>) value;
            for (int i = size()-1; i > 0 && cmp.compareTo(get(i-1)) < 0; i--)
                Collections.swap(this, i, i-1);
        }
    }
}
