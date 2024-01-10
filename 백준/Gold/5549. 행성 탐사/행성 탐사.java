import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][][] cnt;
    static char[] type = new char[]{'J', 'O', 'I'};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = new int[N+1][M+1][3]; // 0 - J, 1 - O, 2 - I
        int T = Integer.parseInt(br.readLine());
        char[][] map = new char[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j-1);
                for (int k = 0; k < 3; k++) {
                    cnt[i][j][k] = cnt[i-1][j][k] + cnt[i][j-1][k] - cnt[i-1][j-1][k];
                    if (map[i][j] == type[k]) {
                        cnt[i][j][k]++;
                    }
                }
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 3; j++) {
                sb.append(cnt[c][d][j] - cnt[c][b-1][j] - cnt[a-1][d][j] + cnt[a-1][b-1][j]).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}