import java.io.*;
import java.util.*;

public class Main {
    static class Diamond {
        double w, c;
        Diamond(double w, double c) {
            this.w = w;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            Diamond[] diamonds = new Diamond[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                double w = Double.parseDouble(st.nextToken());
                double c = Double.parseDouble(st.nextToken());
                diamonds[i] = new Diamond(w, c);
            }

            int[] dp = new int[N];
            int maxLen = 0;

            for (int i = 0; i < N; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (diamonds[j].w < diamonds[i].w && diamonds[j].c > diamonds[i].c) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }

            sb.append(maxLen).append("\n");
        }
        System.out.println(sb);
    }
}