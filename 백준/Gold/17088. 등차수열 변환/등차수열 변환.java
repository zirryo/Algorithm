import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] B = new long[N];
        for (int i = 0; i < N; i++) B[i] = Long.parseLong(st.nextToken());

        if (N == 1 || N == 2) {
            System.out.println(0);
            return;
        }

        int INF = 1_000_000_001;
        int ans = INF;

        int[] opts = {-1, 0, 1};
        for (int o1 : opts) {
            for (int o2 : opts) {
                long C1 = B[0] + o1;
                long C2 = B[1] + o2;
                long d = C2 - C1;

                int cnt = 0;
                if (o1 != 0) cnt++;
                if (o2 != 0) cnt++;

                long prev = C2;
                boolean available = true;
                for (int i = 2; i < N; i++) {
                    long expected = prev + d;
                    long di = expected - B[i];
                    if (di < -1 || di > 1) {
                        available = false;
                        break;
                    }
                    if (di != 0) cnt++;
                    prev = B[i] + di;
                }
                if (available) ans = Math.min(ans, cnt);
            }
        }

        if (ans == INF) System.out.println(-1);
        else System.out.println(ans);
    }
}
