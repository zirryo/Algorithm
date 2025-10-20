import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long ans = 0;

        for (int i = 0; i < N; i++) {
            int j = 0;
            while (j < M) {
                while (j < M && A[i][j] == 0) j++;
                if (j >= M) break;

                int cnt1 = 0, cnt2 = 0;
                int cur = A[i][j];
                if (cur == 1) cnt1++; else cnt2++;

                j++;
                while (j < M && A[i][j] != 0) {
                    if (A[i][j] != cur) {
                        cur = A[i][j];
                        if (cur == 1) cnt1++; else cnt2++;
                    }
                    j++;
                }
                ans += 1 + Math.min(cnt1, cnt2);
            }
        }

        System.out.println(ans);
    }
}
