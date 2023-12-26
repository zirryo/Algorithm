import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] H, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        H = new long[N+1];
        P = new long[N+1];
        H[0] = 1;
        P[0] = 1;
        for (int i=1; i<=N; i++) {
            H[i] = H[i - 1] * 2 + 3;
            P[i] = P[i - 1] * 2 + 1;
        }
        System.out.println(levelHamburger(N, X));
    }
    private static long levelHamburger(int n, long x) {
        if (n == 0) {
            if (x == 0) return 0;
            else return 1;
        }

        if (x == 0) return 0; // 더 먹을 수 없음
        if (H[n - 1] + 2 > x) { // x : n레벨의 가운데 패티 왼쪽 -> n레벨 바닥의 빵을 먹고 n-1레벨 재귀
            return levelHamburger(n-1, x-1);
        } else if (H[n - 1] + 2 == x) { // x : n레벨의 가운데 패티와 일치 -> n-1 레벨 패티 개수 + 중간 패티 1개
            return P[n-1] + 1;
        } else if (H[n - 1] + 2 < x) { // x : n레벨의 가운데 패티 오른쪽 -> n-1 레벨 패티 먹음, 우측은 n-1레벨 재귀
            return P[n-1] + 1 + levelHamburger(n-1, x-2-H[n-1]);
        }
        return P[n]; // x : n레벨 햄버거 레이어 수와 일
    }
}