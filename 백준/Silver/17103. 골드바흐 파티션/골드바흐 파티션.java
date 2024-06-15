import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        setIsPrime();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(goldbachConjecture(N) + "\n");
        }
        System.out.println(sb);
    }
    private static int goldbachConjecture(int x) {
        int cnt = 0;
        for (int i=2; i <= x / 2; i++) {
            if (isPrime[i] && isPrime[x-i]) cnt++;
        }
        return cnt;
    }
    private static void setIsPrime() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i*i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}