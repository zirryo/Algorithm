import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long isqrt(long n) {
        long lo = 0, hi = 2000000000L;
        while (lo <= hi) {
            long mid = (lo + hi) >>> 1;
            long sq = mid * mid;
            if (sq == n) return mid;
            if (sq < n) lo = mid + 1;
            else hi = mid - 1;
        }
        return hi;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long sqCount = isqrt(b) - isqrt(a); 
        long total = b - a;

        if (sqCount == 0) {
            System.out.println(0);
            return;
        }
        long g = gcd(sqCount, total);
        System.out.println((sqCount / g) + "/" + (total / g));
    }
}
