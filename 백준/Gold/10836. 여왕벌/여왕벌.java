import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()); // 격자 크기
        int M = Integer.parseInt(st.nextToken()); // 날자 수
        int[][] result = new int[N][N];
        for (int i=0; i<N; i++) {
            Arrays.fill(result[i], 1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            for (int j = N-1; j >= 0; j--) {
                if (zero > 0) {
                    zero--;
                } else if (one > 0) {
                    one--;
                    result[j][0]++;
                } else {
                    two--;
                    result[j][0] += 2;
                }
            }
            for (int j = 1; j < N; j++) {
                if (zero > 0) {
                    zero--;
                } else if (one > 0) {
                    one--;
                    result[0][j]++;
                } else {
                    two--;
                    result[0][j] += 2;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0) sb.append(result[i][j]).append(" ");
                else sb.append(result[0][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}