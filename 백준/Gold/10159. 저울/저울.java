import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1; // a > b
        }

        floyd();

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (arr[i][j] == 0 && arr[j][i] == 0) cnt++; // i > j, j > i 두 정보를 다 모르면 카운트
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) { // i > k 이고 k > j 이면
                        arr[i][j] = 1; // i > k 이다
                    }
                }
            }
        }
    }
}