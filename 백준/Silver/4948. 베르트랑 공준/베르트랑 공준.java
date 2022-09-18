import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] notPrime = new boolean[246913];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        getPrime();

        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            int cnt = 0;
            for(int i = N+1; i <= 2*N; i++) if(!notPrime[i]) cnt++;
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
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