import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        init();

        int w = makeBoard(1); // (0, 0) 칸이 W 인 경우
        int b = makeBoard(0); // (0, 0) 칸이 B 인 경우

        System.out.println(Math.min(w, b));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                if(s.charAt(j) == 'W') board[i][j] = 1;
            }
        }
    }
    private static int makeBoard(int startColor) {
        int recolor = 2000 * 2000;
        int val;
        int[][] prefixSum = new int[N+1][M+1];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if((i+j) % 2 == 0) val = board[i][j] == startColor ? 0 : 1;
                else val = board[i][j] != startColor ? 0 : 1;
                prefixSum[i+1][j+1] = prefixSum[i][j+1] + prefixSum[i+1][j] - prefixSum[i][j] + val;
            }
        }

        for(int i=1; i<=N-K+1; i++) {
            for(int j=1; j<=M-K+1; j++) {
                recolor = Math.min(prefixSum[i+K-1][j+K-1] - prefixSum[i+K-1][j-1] - prefixSum[i-1][j+K-1] + prefixSum[i-1][j-1], recolor);
            }
        }

        return recolor;
    }
}