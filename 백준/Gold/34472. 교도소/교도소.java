import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] a = new long[N];
        long total = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(st.nextToken());
            total += a[i];
        }

        long per = total / N;

        long[] prefix = new long[N + 1];
        long minPrefix = 0L;
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + (a[i - 1] - per);
            minPrefix = Math.min(minPrefix, prefix[i]);
        }

        long result = 0;
        for (int i = 1; i <= N; i++) {
            result += (prefix[i] - minPrefix);
        }

        System.out.println(result);
    }
}
