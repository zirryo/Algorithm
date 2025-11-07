import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            long N = Long.parseLong(br.readLine().trim());

            int r = (int)Math.floor(Math.sqrt((double)N));
            while ((long)r * r > N) r--;
            while ((long)(r + 1) * (r + 1) <= N) r++;

            long sum1 = r + divCeil(N, r);
            long sum2 = (r + 1) + divCeil(N, r + 1);

            long minSum = Math.min(sum1, sum2);
            long perimeter = 2L * minSum;
            sb.append(perimeter).append('\n');
        }

        System.out.print(sb.toString());
    }

    static long divCeil(long a, long b) {
        return (a + b - 1) / b;
    }
}
