import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long L = Long.parseLong(st.nextToken());

        long[] x = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            x[i] = Long.parseLong(st.nextToken());
        }

        long[] suffixSum = new long[n + 2];
        for (int i = n; i >= 1; i--) {
            suffixSum[i] = suffixSum[i + 1] + x[i];
        }

        for (int i = 1; i < n; i++) {
            int count = n - i;
            double avg = (suffixSum[i + 1] * 1.0) / count;
            double left = x[i] - L;
            double right = x[i] + L;
            if (avg <= left || avg >= right) {
                System.out.println("unstable");
                return;
            }
        }

        System.out.println("stable");
    }
}
