package implementations;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/25/17.
 */
public class AlmostSorted {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int prevVal= Integer.MIN_VALUE;
        int[] arr= new int[n];
        boolean alreadySorted= true;
        int indexWhereSortingBreaks=0;
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            if(alreadySorted && arr[i]<prevVal){
                alreadySorted = false;
                indexWhereSortingBreaks=i-1;
            }
            prevVal = arr[i];
        }

        if(alreadySorted) {
            System.out.println("yes");
        }
        else{
            if(arr[indexWhereSortingBreaks]>arr[indexWhereSortingBreaks+1]) {
                int toReplace = findClosestIndex(arr,indexWhereSortingBreaks);
                //System.out.printf("pos1:%d,pos2:%d",indexWhereSortingBreaks+1,toReplace );
                swap(arr, indexWhereSortingBreaks,toReplace);
                //System.out.println(Arrays.toString(arr));
                if(checkSorted(arr)) {
                    System.out.println("yes");
                    System.out.printf("swap %d %d",indexWhereSortingBreaks+1,toReplace+1);
                    return;
                }
                //reverse
                swap(arr, indexWhereSortingBreaks,toReplace);

                //find sequence that is reversed
                LinkedList<Integer> subList = new LinkedList<>();

                for(int i=indexWhereSortingBreaks;i<n-1;i++){
                    if(arr[i]>arr[i+1]){
                        subList.add(arr[i]);
                    }else{
                        subList.add(arr[i]);
                        break;
                    }
                }
                int itemsTobeReversed= subList.size();
                int index=indexWhereSortingBreaks;
                //replace items in org array
                while(subList.size()>0)
                    arr[index++]=subList.removeLast();

                if(checkSorted(arr)) {
                    System.out.println("yes");
                    System.out.printf("reverse %d %d",indexWhereSortingBreaks+1,indexWhereSortingBreaks+itemsTobeReversed);
                    return;
                }else{
                    System.out.println("no");
                }


            }
        }
    }

    private static int findClosestIndex(int[] arr, int cI) {
        int closestIndex=cI+1,closestDiff=Integer.MAX_VALUE;
        int sourceVal;
        if(cI==0) {
            sourceVal = arr[cI];
            closestIndex=cI+1;
            cI+=1;
        }
        else
            sourceVal = arr[cI - 1];
        for (int i = cI; i < arr.length; i++) {
            final int diff = arr[i] - sourceVal;
            if (diff < closestDiff) {
                closestDiff = diff;
                closestIndex = i;
            }
        }
        return closestIndex;
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos2];
        arr[pos2]=arr[pos1];
        arr[pos1]=temp;
    }

    private static boolean checkSorted(int[] arr){
        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
}
