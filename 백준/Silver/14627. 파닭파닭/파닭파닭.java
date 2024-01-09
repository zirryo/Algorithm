import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int S, C;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long total = 0;
        arr = new long[S];
        for (int i = 0; i < S; i++) {
            arr[i] = Long.parseLong(br.readLine());
            total += arr[i];
        }
        
        long ans = total - (binarySearch() * C);
        System.out.println(ans);
    }
    private static long binarySearch() {
        long l = 1L;
        long r = 1_000_000_000L;
        long result = 0L;

        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = 0;
            for (long x : arr) {
                cnt += x / mid;
            }

            if (cnt >= C) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}