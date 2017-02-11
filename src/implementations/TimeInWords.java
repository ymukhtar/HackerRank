package implementations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by yasir_mukhtar on 1/26/17.
 */
public class TimeInWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hour = in.nextInt();
        int minute = in.nextInt();

        String[] digitTranslations = {"one","two","three","four","five","six","seven","eight",
                "nine","ten","eleven","twelve","thirteen","fourteen","quarter","sixteen","seventeen","eighteen","nineteen","twenty",
                "twenty one","twenty two","twenty three","twenty four","twenty five","twenty six","twenty seven","twenty eight","twenty nine","half"};

        if(minute==0){
            System.out.printf("%s o' clock",digitTranslations[hour-1]);
        }
        else if(minute==15){
            System.out.printf("quarter past %s",digitTranslations[hour-1]);
        }
        else if(minute<30){
            System.out.printf("%s minutes past %s",digitTranslations[minute-1],digitTranslations[hour-1]);
        }
        else if(minute==30){
            System.out.printf("half past %s",digitTranslations[hour-1]);
        }
        else{
            int rem_min = 60-minute;
            if(rem_min==15){
                System.out.printf("quarter to %s",digitTranslations[hour]);
            }
            else{
                System.out.printf("%s minutes to %s",digitTranslations[rem_min-1],digitTranslations[hour]);
            }
        }
    }
}
