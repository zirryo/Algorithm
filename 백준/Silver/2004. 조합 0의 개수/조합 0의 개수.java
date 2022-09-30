import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long cnt5 = cntFive(N) - cntFive(N-M) - cntFive(M);
        long cnt2 = cntTwo(N) - cntTwo(N-M) - cntTwo(M);
        System.out.println(Math.min(cnt5, cnt2));

    }
    static int cntFive(long k) {
        int cnt = 0;
        while(k >= 5) {
            cnt += (k / 5);
            k /= 5;
        }
        return cnt;

    }
    static int cntTwo(long k) {
        int cnt = 0;
        while(k >= 2) {
            cnt += (k / 2);
            k /= 2;
        }
        return cnt;

    }
}