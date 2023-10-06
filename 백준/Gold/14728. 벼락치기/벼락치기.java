import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        Lecture[] lectures = new Lecture[N+1];
        int[][] dp = new int[N+1][T+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(K, S);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= T; j++) {
                if (lectures[i].k <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-lectures[i].k] + lectures[i].s);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][T]);
    }
}
class Lecture {
    int k;
    int s;

    public Lecture(int k, int s) {
        this.k = k;
        this.s = s;
    }
}