package implementations;
import java.util.Scanner;

public class SpaceStation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cities = in.nextInt();
        int space_stations_count = in.nextInt();
        int[] distances = new int[cities];
        int[] space_stations = new int[cities];

        for (int i = 0; i < space_stations_count; i++) {
            space_stations[in.nextInt()] = 1;
        }
        for(int city =0; city<cities;city++){
            if(space_stations[city]==1){
                distances[city] = 0;
            }else{
                int d1= forwardDistance(city,cities,space_stations);
                int d2= backwardDistance(city,space_stations);
                distances[city] = Math.min(d1,d2);
            }
        }
        System.out.println(findMax(distances));
    }

    private static int findMax(int[] distances) {
        int max= Integer.MIN_VALUE;
        for(int d:distances){
            if(d>max)
                max= d;
        }
        return max;
    }

    private static int backwardDistance(int city, int[] space_stations) {
        for(int i=city-1;i>=0;i--){
            if(space_stations[i]==1){
                return city-i;
            }
        }
        return Integer.MAX_VALUE;
    }

    private static int forwardDistance(int city, int cities, int[] space_stations) {
        for(int i=city+1;i<cities;i++){
            if(space_stations[i]==1){
                return i-city;
            }
        }
        return Integer.MAX_VALUE;
    }
}
