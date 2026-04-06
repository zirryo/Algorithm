import java.util.*;
import java.io.*;

public class Main {
    public static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long result = Math.abs(arr[0] - arr[1]);

        for (int i = 1; i < n - 1; i++) {
            long diff = Math.abs(arr[i] - arr[i + 1]);
            result = gcd(result, diff);
        }

        System.out.println(result);
    }
}