import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int len = N.length();
        int[] arr = new int[10];

        for(int i=0; i<len; i++) {
            arr[N.charAt(i) - '0']++;
        }
        for(int i=9; i>=0; i--) {
            while(arr[i]-- > 0) System.out.print(i);
        }
    }
}