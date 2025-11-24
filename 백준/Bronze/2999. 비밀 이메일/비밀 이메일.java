import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();

        int R = 1, C = N;
        for (int r = 1; r * r <= N; r++) {
            if (N % r == 0) {
                int c = N / r;
                if (r <= c) {
                    R = r;
                    C = c;
                }
            }
        }

        char[][] arr = new char[R][C];
        int idx = 0;
        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                arr[r][c] = S.charAt(idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(arr[r][c]);
            }
        }

        System.out.println(sb);
    }
}
