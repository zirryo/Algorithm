import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] map;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new int[N];
        cnt = new int[N];


        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        if (map[0] == 0 && N != 1) {
            System.out.println(-1);
            System.exit(0);
        } else {
            Arrays.fill(cnt, 1001);
            cnt[0] = 0;
        }

        for (int i = 0; i < N; i++) {
            int x = map[i];
            for (int j = 1; j <= x; j++) {
                if (i + j >= N) continue;
                if (cnt[i + j] > cnt[i] + 1) {
                    cnt[i + j] = cnt[i] + 1;
                }
            }
        }

        if (cnt[N-1] == 1001) System.out.println(-1);
        else System.out.println(cnt[N-1]);
    }
}