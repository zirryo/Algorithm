import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int minR = R;
        int maxR = 0;
        int minC = C;
        int maxC = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        char[][] before = new char[R][C];
        char[][] after = new char[R][C];

        for (int i=0; i<R; i++) {
            before[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (before[i][j] == 'X') {
                    int cnt = 0;
                    for (int k=0; k<4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr < 0 || nc < 0 || nr >= R || nc >= C || before[nr][nc] == '.') {
                            cnt++;
                        }
                    }

                    if (cnt < 3) {
                        after[i][j] = 'X';
                        minR = Math.min(minR, i);
                        maxR = Math.max(maxR, i);
                        minC = Math.min(minC, j);
                        maxC = Math.max(maxC, j);
                    } else {
                        after[i][j] = '.';
                    }
                } else {
                    after[i][j] = '.';
                }
            }
        }

        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                sb.append(after[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}