import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] notPrime = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        getPrime();

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            int first = K / 2;
            int last = K / 2;

            while(true) {
                if(!notPrime[first] && !notPrime[last]) {
                    sb.append(first + " " + last + "\n");
                    break;
                }
                first--;
                last++;
            }
        }
        System.out.println(sb);
    }
    static void getPrime() {
        notPrime[0] = true;
        notPrime[1] = true;

        for(int i=2; i <= Math.sqrt(notPrime.length); i++) {
            if(notPrime[i]) continue;
            for(int j = i*i; j< notPrime.length; j +=i) {
                notPrime[j] = true;
            }
        }
    }
}