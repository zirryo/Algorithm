import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 101;
    static int N;
    static int[][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cost = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(cost[i], INF);
            cost[i][i] = 0;
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cost[a][b] = 1;
            cost[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }

        int minSum = INF * N * 2;
        int num1 = 0;
        int num2 = 0;

        for (int i = 1; i < N; i++) { // i - 첫번째 치킨집
            for (int j = i+1; j <= N; j++) { // j - 두번째 치킨집
                int tempSum = 0;
                for (int k = 1; k <= N; k++) { // k - 건물 번호
                    tempSum += 2 * Math.min(cost[i][k], cost[j][k]);
                }

                if (minSum > tempSum) {
                    minSum = tempSum;
                    num1 = i;
                    num2 = j;
                }
            }
        }

        System.out.printf("%d %d %d", num1, num2, minSum);
    }
}