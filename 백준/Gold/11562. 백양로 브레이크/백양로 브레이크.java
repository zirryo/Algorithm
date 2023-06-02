import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1]; // arr[i][j] = i에서 j로 갈때 변경해야 하는 일방통행 길의 수

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (i != j) arr[i][j] = 250 * 250;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[u][v] = 0;
            if (b == 1) arr[v][u] = 0;
            else arr[v][u] = 1;
        }
        floydWarshall();

        int questions = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (questions-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(arr[s][e]).append("\n");
        }

        System.out.println(sb);
    }
    private static void floydWarshall() {
        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
    }
}