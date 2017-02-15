package stacks;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/11/17.
 */
public class LargestRectangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] input = new int[t];
        for (int i = 0; i < t; i++) {
            input[i] = in.nextInt();
        }
        int pos =0, area = -1, max_area = -1, tempPos =0;
        Stack<Integer> positions = new Stack<>(), heights = new Stack<>();
        for(;pos<input.length;pos++){
            //if stack is empty and current top is less then value passed
            if(heights.isEmpty() || heights.peek() <= input[pos]){
                heights.push(input[pos]);
                positions.push(pos);
            }
            else{
                while(!heights.isEmpty() && heights.peek() > input[pos]){
                    tempPos = positions.pop();
                    area = heights.pop() * (pos-tempPos);
                    if(area>max_area)
                        max_area = area;
                }
                heights.push(input[pos]);
                positions.push(tempPos);
            }
        }
        while(!heights.isEmpty()){
            area = heights.pop() * (pos-positions.pop());
            if(area>max_area)
                max_area = area;
        }
        System.out.println(max_area);
    }
}
