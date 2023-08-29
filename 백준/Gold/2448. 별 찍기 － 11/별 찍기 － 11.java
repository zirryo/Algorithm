import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = 2 * N - 1;
        arr = new boolean[N][M];
        dfs(0, N - 1, N);

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j]) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int r, int c, int size) {
        if (size == 3) {
            arr[r][c] = true;
            arr[r+1][c-1] = true;
            arr[r+1][c+1] = true;
            for (int i=-2; i<=2; i++) arr[r+2][c+i] = true;
        } else {
            int temp = size / 2;
            dfs(r, c, temp);
            dfs(r + temp, c - temp, temp);
            dfs(r + temp, c + temp, temp);
        }
    }
}