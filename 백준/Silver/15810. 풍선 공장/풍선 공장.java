import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N, M;
    static long[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        time = new long[(int)N];
        st = new StringTokenizer(br.readLine());
        long min = 1_000_001;
        for (int i=0; i<N; i++) {
            time[i] = Long.parseLong(st.nextToken());
            min = Math.min(min, time[i]);
        }

        long result = parametricSearch(1, min * M);
        System.out.println(result);
    }
    private static long parametricSearch(long l, long r) {
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = 0;

            for (long t : time) {
                cnt += mid / t;
            }

            if (cnt >= M) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}