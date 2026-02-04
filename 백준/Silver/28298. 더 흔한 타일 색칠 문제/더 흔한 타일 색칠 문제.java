import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int[][][] count = new int[K][K][26];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                count[i % K][j % K][grid[i][j] - 'A']++;
            }
        }

        char[][] pattern = new char[K][K];
        long totalChanges = 0;
        int blockArea = (N / K) * (M / K);

        for (int r = 0; r < K; r++) {
            for (int c = 0; c < K; c++) {
                int maxFreq = 0;
                int bestColor = 0;
                for (int color = 0; color < 26; color++) {
                    if (count[r][c][color] > maxFreq) {
                        maxFreq = count[r][c][color];
                        bestColor = color;
                    }
                }
                pattern[r][c] = (char) (bestColor + 'A');
                totalChanges += (blockArea - maxFreq);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(totalChanges).append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(pattern[i % K][j % K]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}