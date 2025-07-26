import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static final int N = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        double[][] transition = new double[N][N];

        for (int i = 0; i < M; i++) {
            String[] parts = br.readLine().split(" ");
            int from = parts[0].charAt(0) - 'A';
            int to = parts[1].charAt(0) - 'A';
            double prob = Double.parseDouble(parts[2]);
            transition[from][to] = prob;
        }

        double[] current = new double[N];
        Arrays.fill(current, 0.25);

        for (int t = 0; t < T; t++) {
            double[] next = new double[N];
            for (int from = 0; from < N; from++) {
                for (int to = 0; to < N; to++) {
                    next[to] += current[from] * transition[from][to];
                }
            }
            current = next;
        }

        for (int i = 0; i < N; i++) {
            System.out.printf("%.2f\n", current[i] * 100);
        }
    }
}
