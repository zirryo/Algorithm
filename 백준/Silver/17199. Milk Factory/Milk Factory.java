import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] connect = new boolean[N+1][N+1];
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connect[a][b] = true;
        }
        for (int i=1; i<=N; i++) connect[i][i] = true;

        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    if (connect[i][k] && connect[k][j]) connect[i][j] = true;
                }
            }
        }

        int result = -1;
        for (int i = 1; i <= N; i++) {
            boolean flag = true;
            for (int j = 1; j <= N; j++) {
                if (!connect[i][j] && !connect[j][i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result = i;
                break;
            }
        }
        System.out.println(result);

    }
}