package heap;

import java.util.*;

/**
 * Created by yasir_mukhtar on 2/23/17.
 */
public class MAWT2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeSet<Customer> cList = new TreeSet<>(Comparator.comparing(o->o.arrival_time));
        for (int i = 0; i < n; i++) {
            cList.add(new Customer(in.nextLong(), in.nextLong(), i));
        }
        long sTime = System.currentTimeMillis();
        Queue<Customer> arrival_que = new PriorityQueue<>(Comparator.comparing(o -> o.arrival_time));
        Queue<Customer> cook_que = new PriorityQueue<>(Comparator.comparing(o -> o.cooking_time));
        Customer cust = cList.pollFirst(),a_cust,c_cust;
        arrival_que.add(cust);
        Customer ct;
        int cl_size=cList.size();
        long cur_time =cust.arrival_time,wait_time_agg=0l; //first person
        while(cl_size!=0 || !arrival_que.isEmpty()){
            Iterator<Customer> itr = cList.iterator();
            while(itr.hasNext()) {
               ct = itr.next();
                if(ct.arrival_time<=cur_time || arrival_que.size()==0){
                    arrival_que.add(ct);
                    cook_que.add(ct);
                    itr.remove();
                    cl_size --;
                }else{
                    break;
                }
            }
            a_cust = arrival_que.peek();
            c_cust = cook_que.isEmpty()?null:cook_que.peek();
            if(c_cust==null){
                cust = a_cust;
            }
            else if(c_cust.cooking_time<a_cust.cooking_time){
                cust = c_cust;
            }
            else{
                cust = a_cust;
            }
            cur_time += (cust.cooking_time);
            wait_time_agg += (cur_time - cust.arrival_time);
            arrival_que.remove(cust);
            cook_que.remove(cust);
            if(cl_size>0)
                cList.remove(cust);
        }
        System.out.println(wait_time_agg / n);
        System.out.println("Time taken:"+(System.currentTimeMillis()-sTime)/1000.0);
    }

    public static class Customer{
        long arrival_time;
        long cooking_time;
        long customer_no;

        public Customer(long arrival_time, long cooking_time, long customer_no) {
            this.arrival_time = arrival_time;
            this.cooking_time = cooking_time;
            this.customer_no = customer_no;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Customer customer = (Customer) o;

            return customer_no == customer.customer_no;
        }

        @Override
        public int hashCode() {
            return (int) (customer_no ^ (customer_no >>> 32));
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "arrival_time=" + arrival_time +
                    ", cooking_time=" + cooking_time +
                    ", customer_no=" + customer_no +
                    '}';
        }
    }
}
