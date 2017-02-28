//package heap;
//
//import org.omg.PortableInterceptor.INACTIVE;
//
//import java.util.*;
//
///**
// * Created by yasir_mukhtar on 2/23/17.
// */
//public class MAWT {
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        List<Customer> cList = new ArrayList<>(n);
//        Customer c;
//        long min_arr_time = Long.MAX_VALUE;
//
//        for (int i = 0; i < n; i++) {
//            c = new Customer(in.nextLong(), in.nextLong(), i);
//            cList.add(c);
//            min_arr_time = Math.min(min_arr_time, c.arrival_time);
//        }
//
//        Queue<Customer> arrival_que = new PriorityQueue<>(Comparator.comparing(o -> o.arrival_time));
//        Queue<Customer> cook_que = new PriorityQueue<>(Comparator.comparing(o -> o.cooking_time));
//
//        arrival_que.addAll(cList);
//
//
//        long wait_time_agg = 0;
//        long cooking_end = 0;
//        Customer cust_arrival, cust_cooking, cust;
//        while (!arrival_que.isEmpty()) {
//            //by arriving time
//            cust_arrival = arrival_que.peek();
//            //by cooking time
//            cust_cooking = cook_que.peek();
//            if(cooking_end>= cust_arrival.arrival_time && cooking_end>=cust_cooking.arrival_time){
//                cust = cust_arrival.cooking_time<cust_cooking.cooking_time?cust_arrival:cust_cooking;
//            }
//            else if( cust_arrival.arrival_time<cust_cooking.arrival_time){
//                cust = cust_arrival;
//            }
//           else{
//                cust = cust_cooking;
//            }
//            System.out.println("-->serving:" + cust.customer_no);
//            cooking_end += (cust.cooking_time);
//            wait_time_agg += (cooking_end - cust.arrival_time);
//            arrival_que.remove(cust);
//            cook_que.remove(cust);
//        }
//        System.out.println(wait_time_agg / n);
//    }
//
//    public static class Customer{
//        long arrival_time;
//        long cooking_time;
//        long customer_no;
//
//        public Customer(long arrival_time, long cooking_time, long customer_no) {
//            this.arrival_time = arrival_time;
//            this.cooking_time = cooking_time;
//            this.customer_no = customer_no;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Customer customer = (Customer) o;
//
//            return customer_no == customer.customer_no;
//        }
//
//        @Override
//        public int hashCode() {
//            return (int) (customer_no ^ (customer_no >>> 32));
//        }
//
//        @Override
//        public String toString() {
//            return "Customer{" +
//                    "arrival_time=" + arrival_time +
//                    ", cooking_time=" + cooking_time +
//                    ", customer_no=" + customer_no +
//                    '}';
//        }
//    }
//}
