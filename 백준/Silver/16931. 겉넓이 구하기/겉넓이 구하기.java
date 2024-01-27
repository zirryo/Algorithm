import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] blocks = new int[N+2][M+2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                blocks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = N * M * 2; // 윗면, 아랫면 겉넓이 (칸당 최소 1개의 블록이 놓임)
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    int diff = blocks[i][j] - blocks[nr][nc];
                    if (diff > 0) result += diff;
                    // 상하좌우 인접블록보다 튀어나온 면을 더함.
                }
            }
        }
        System.out.println(result);
    }
}