import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] pick;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pick = new int[N];

        for (int i = 0; i < N; i++) {
            pick[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(theGameOfDeath());

    }
    private static int theGameOfDeath() {
        boolean[] picked = new boolean[N];
        picked[0] = true;
        int player = 0; // 0번 플레이어부터 지목 시작
        int cnt = 0;

        while (true) {
            cnt++;
            player = pick[player];
            if (player == M) break;
            if (picked[player]) return -1;
            picked[player] = true;
        }

        return cnt;
    }
}