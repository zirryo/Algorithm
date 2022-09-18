import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] notPrime = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        getPrime();

        int sum = 0;
        int min = 0;
        for(int i = M; i <= N; i++) {
            if(!notPrime[i]) {
                if(sum == 0) min = i;
                sum += i;
            }
        }
        if(sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
    static void getPrime() {
        notPrime[0] = true;
        notPrime[1] = true;
        for(int i=2; i <=Math.sqrt(notPrime.length); i++) {
            if(notPrime[i]) continue;
            for(int j = i*i; j< notPrime.length; j += i) notPrime[j] = true;
        }
    }
}
