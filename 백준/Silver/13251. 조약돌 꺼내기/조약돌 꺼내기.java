import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int[] stones = new int[M];
        int totalStones = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
            totalStones += stones[i];
        }

        int K = Integer.parseInt(br.readLine());
        double result = 0.0;

        for (int i = 0; i < M; i++) {
            if (stones[i] >= K) {
                double cur = 1.0;
                for (int j = 0; j < K; j++) {
                    cur *= (stones[i] - j) / (double) (totalStones - j);
                }
                result += cur;
            }
        }

        System.out.print(result);
    }
}
