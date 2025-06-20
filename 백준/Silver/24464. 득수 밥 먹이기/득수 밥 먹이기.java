import java.io.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] prev = new long[5];
        long[] curr = new long[5];

        prev[0] = 1;
        for (int i = 1; i <= 4; i++) prev[i] = 1;

        for (int day = 2; day <= N; day++) {
            curr[0] = (prev[1] + prev[2] + prev[3] + prev[4]) % MOD; // 오늘 굶기

            for (int j = 1; j <= 4; j++) { // 오늘 식당 방문
                curr[j] = prev[0]; // 어제 굶음

                for (int k = 1; k <= 4; k++) { // 어제 안 굶음
                    if (Math.abs(j - k) >= 2) {
                        curr[j] = (curr[j] + prev[k]) % MOD;
                    }
                }
            }

            long[] tmp = prev;
            prev = curr;
            curr = tmp;
        }

        long ans = 0;
        for (int i = 0; i <= 4; i++) ans = (ans + prev[i]) % MOD;
        System.out.println(ans);
    }
}
