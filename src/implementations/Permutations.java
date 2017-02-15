package implementations;

/**
 * Created by yasir_mukhtar on 2/12/17.
 */
public class Permutations {
    public static void main(String[] args) {
        String input = "ABC";
        makePerm(input.toCharArray(),0,input.length());
    }

    private static void makePerm(char[] str, int i, int n) {
        if(i==n){
            System.out.println(str);
        }else{
            for(int j=i;j<n;j++){
                swap(str,i,j);
                makePerm(str,i+1,n);
                swap(str,i,j);
            }
        }

    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
