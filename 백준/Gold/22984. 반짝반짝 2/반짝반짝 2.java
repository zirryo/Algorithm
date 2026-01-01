import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double[] p = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            p[i] = Double.parseDouble(st.nextToken());
        }

        double expectedValue = 0.0;

        for (int i = 0; i < N; i++) {
            expectedValue += p[i];
        }

        for (int i = 0; i < N - 1; i++) {
            // 이웃한 두 전구 중 하나만 켜질 확률: p1(1-p2) + p2(1-p1)
            double probExtra = p[i] * (1 - p[i + 1]) + p[i + 1] * (1 - p[i]);
            expectedValue += probExtra;
        }

        System.out.printf("%.6f\n", expectedValue);
    }
}