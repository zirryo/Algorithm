import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result = 0;
    static int[][] degree;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        degree = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                degree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if ((N <= 1 && M <= 2) || (N <= 2 && M <= 1)) {
            System.out.println(0);
            return;
        } else {
            makeBoomerang(0, 0);
            System.out.println(result);
        }
    }
    private static void makeBoomerang(int position, int sum) {
        // position - 부메랑의 중심, sum - 부메랑 강도의 합
        if (position == (N * M)) {
            result = Math.max(result, sum);
            return;
        }

        int r = position / M;
        int c = position % M;

        makeBoomerang(position + 1, sum);
        if (visited[r][c]) return;

        if (r - 1 >= 0 && !visited[r-1][c]) {
            if (c - 1 >= 0 && !visited[r][c-1]) { // 'ㄴ' 좌우반전
                visited[r][c] = true;
                visited[r-1][c] = true;
                visited[r][c-1] = true;
                int curSum = degree[r][c] * 2 + degree[r-1][c] + degree[r][c-1];
                makeBoomerang(position + 1, sum + curSum);
                visited[r][c] = false;
                visited[r-1][c] = false;
                visited[r][c-1] = false;
            }
            if (c + 1 < M && !visited[r][c+1]) { // 'ㄴ' 모양
                visited[r][c] = true;
                visited[r-1][c] = true;
                visited[r][c+1] = true;
                int curSum = degree[r][c] * 2 + degree[r-1][c] + degree[r][c+1];
                makeBoomerang(position + 1, sum + curSum);
                visited[r][c] = false;
                visited[r-1][c] = false;
                visited[r][c+1] = false;
            }
        }
        if (r + 1 < N && !visited[r+1][c]) {
            if (c - 1 >= 0 && !visited[r][c-1]) { // 'ㄱ' 모양
                visited[r][c] = true;
                visited[r+1][c] = true;
                visited[r][c-1] = true;
                int curSum = degree[r][c] * 2 + degree[r+1][c] + degree[r][c-1];
                makeBoomerang(position + 1, sum + curSum);
                visited[r][c] = false;
                visited[r+1][c] = false;
                visited[r][c-1] = false;
            }
            if (c + 1 < M && !visited[r][c+1]) { // 'ㄱ' 좌우반전
                visited[r][c] = true;
                visited[r+1][c] = true;
                visited[r][c+1] = true;
                int curSum = degree[r][c] * 2 + degree[r+1][c] + degree[r][c+1];
                makeBoomerang(position + 1, sum + curSum);
                visited[r][c] = false;
                visited[r+1][c] = false;
                visited[r][c+1] = false;
            }
        }
    }
}