package stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yasir_mukhtar on 2/12/17.
 */
public class EqualStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();

        int[] s1 = new int[n1], s2 = new int[n2], s3 = new int[n3];
        int sum1=0, sum2=0, sum3=0;

        for(int h1_i=0; h1_i < n1; h1_i++){
            s1[h1_i]= in.nextInt();
            sum1 += s1[h1_i];
        }

        for(int h2_i=0; h2_i < n2; h2_i++){
            s2[h2_i]= in.nextInt();
            sum2 += s2[h2_i];
        }

        for(int h3_i=0; h3_i < n3; h3_i++){
            s3[h3_i]= in.nextInt();
            sum3 += s3[h3_i];
        }

        int top1 =0, top2=0, top3=0;
        while(true){
            //System.out.println(sum1+","+sum2+","+sum3);
            if(sum1>sum2 || sum1>sum3){
                top1++;
                sum1 -= s1[top1-1];
            }
            else if(sum2>sum1 || sum2>sum3){
                top2++;
                sum2 -= s2[top2-1];
            }
            else if(sum3>sum1 || sum3>sum2){
                top3++;
                sum3 -= s3[top3-1];
            }
            else{
                System.out.println(sum1);
                break;
            }
        }
    }
}
