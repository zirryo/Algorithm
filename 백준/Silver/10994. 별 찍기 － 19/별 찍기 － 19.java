import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int X = 4 * N - 3;
        int size = 0;
        boolean[][] star = new boolean[X][X];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = size; j < X-size; j++) {
                star[size][j] = true; // 위
                star[X-1-size][j] = true; // 아래
                star[j][size] = true; // 왼쪽
                star[j][X-1-size] = true; // 오른쪽
            }
            size += 2;
        }

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < X; j++) {
                if (star[i][j]) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}