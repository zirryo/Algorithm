import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        arr[0][1] = 1;
        for (int i=1; i<=N; i++) {
           for (int j=1; j<=M; j++) {
               arr[i][j] = arr[i-1][j] + arr[i][j-1];
           }
        }

        System.out.println(solve());
    }
    private static int solve() {
        if (K == 0) return arr[N][M];
        int r1 = K / M  + (K % M == 0 ? 0 : 1);
        int c1 = K - (r1 - 1) * M;
        int r2 = N - r1 + 1;
        int c2 = M - c1 + 1;
        return arr[r1][c1] * arr[r2][c2];
    }
}