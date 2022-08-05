import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())-1;
        honeycomb(N);
    }
    static void honeycomb (int N) {
        if(N==0) {
            System.out.println(1);
            return;
        }
        int i = 1;
        while(N > 6*i) {
            N = N - 6*i;
            i++;
        }
        System.out.println(i+1);
    }

}