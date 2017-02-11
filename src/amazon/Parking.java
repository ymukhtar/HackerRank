package amazon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by yasir_mukhtar on 2/3/17.
 */
/*
        4
        adrian building1 building2
        john building2 building1
        andrew building3 building2
        william building2 building1
        */
public class Parking {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<RequestForParking> myRequests = new HashSet<>();
        int t = in.nextInt();// number of test cases
        for (int i = 0; i < t; i++) {
            RequestForParking rfp = new RequestForParking(in.next(), in.next(), in.next());
            if (myRequests.contains(rfp)) {
                for (RequestForParking obj : myRequests){
                    if(obj.equals(rfp)){
                        System.out.println(obj.name+","+ rfp.name);
                    }
                }
            } else {
                myRequests.add(rfp);
            }
        }
    }

    public static class RequestForParking {
        String name;
        String sourceBuilding;
        String destBuilding;

        public RequestForParking(String name, String sourceB, String destB) {
            this.name = name;
            this.sourceBuilding = sourceB;
            this.destBuilding = destB;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RequestForParking that = (RequestForParking) o;

            if (!sourceBuilding.equals(that.destBuilding)) return false;
            return destBuilding.equals(that.sourceBuilding);
        }

        @Override
        public int hashCode() {
            return sourceBuilding.hashCode()+ destBuilding.hashCode();
        }

    }
}
