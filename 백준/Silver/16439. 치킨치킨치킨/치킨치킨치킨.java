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
        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < M-2; i++) {
            for (int j = i + 1; j < M-1; j++) {
                for (int k = j + 1; k < M; k++) {
                    int sum = 0;
                    for (int l=0; l<N; l++) {
                        sum += Math.max(grid[l][i], Math.max(grid[l][j], grid[l][k]));
                    }
                    if (result < sum) {
                        result = sum;
                    }
                }
            }
        }

        System.out.println(result);

    }
}
