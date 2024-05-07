import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dist = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(dist[i], 1_000_000);
                dist[i][i] = 0;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                dist[a][b] = c;
                dist[b][a] = c;
            }
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] friends = new int[K];
            for (int i=0; i<K; i++) {
                friends[i] = Integer.parseInt(st.nextToken());
            }

            dijkstra();
            sb.append(findMinDistPlace(friends)).append("\n");
        }
        System.out.println(sb);
    }
    private static void dijkstra() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (k == i) continue;
                for (int j = 1; j <= N; j++) {
                    if (k == j || i == j) continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
    private static int findMinDistPlace(int[] arr) {
        int placeNum = 0;
        int minDist = 1_000_000_000;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int x : arr) {
                sum += dist[i][x];
            }
            if (minDist > sum) {
                minDist = sum;
                placeNum = i;
            }
        }
        return placeNum;
    }
}