package stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yasir_mukhtar on 2/13/17.
 */
public class Waiter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt(), q = in.nextInt();
        Stack<Integer> a = new Stack<>();
        List<Stack<Integer>> bStackList = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(in.nextInt());
        }
        List<Integer> primes = generatePrimes(q);
        for(int qi =0;qi<q;qi++){
            if(a.size()==0){
                break;
            }
            Stack<Integer> tempA = new Stack<>(),tempB= new Stack<>();
            while(!a.isEmpty()){
                int top = a.pop();
                if(top%primes.get(qi)==0){
                    tempB.push(top);
                }
                else
                    tempA.push(top);
            }
            a = tempA;
            bStackList.add(tempB);
        }
        for(int i=0;i<bStackList.size();i++) {
            Stack<Integer> b = bStackList.get(i);
            while (b != null && !b.isEmpty())
                System.out.println(b.pop());
        }
        while(!a.isEmpty())
            System.out.println(a.pop());

    }

    private static List<Integer> generatePrimes(int q) {
        List<Integer> a = new ArrayList<>(q);
        if(q==1){
            a.add(2);
        }
        else{
            a.add(2);
            a.add(3);
            while(a.size()<q){
                a.add(generateNextPrime(a.get(a.size()-1)));
            }
        }
        return a;
    }

    private static Integer generateNextPrime(Integer start) {
        int next = start;
        while(true){
            next = next+2;
            if(isPrime(next))
                return next;
        }
    }

    private static boolean isPrime(int next) {
        if(next ==2 || next == 3)
            return true;
        for(int i =3;i<=Math.sqrt(next);i++){
            if(next%i==0)
                return false;
        }
        return true;
    }

}
