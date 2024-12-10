import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[][] maxCost = new int[n][2];
            for (int i = 0; i < n; i++) {
                maxCost[i][0] = Integer.parseInt(st.nextToken());
                maxCost[i][1] = i;
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += maxCost[i][0];
            }

            if (sum < p) {
                sb.append("IMPOSSIBLE\n");
                continue;
            }

            int[] result = new int[n];

            Arrays.sort(maxCost, (x, y) -> {
                if (x[0] != y[0]) {
                    return Integer.compare(x[0], y[0]);
                }
                return Integer.compare(y[1], x[1]);
            });


            int remain = p;

            for (int i = 0; i < n; i++) {
                if (remain == 0) break;
                int curIdx = maxCost[i][1];
                result[curIdx] = Math.min(maxCost[i][0], remain / (n - i));
                remain -= result[curIdx];
            }

            if (remain > 0) {
                for (int i = n - 1; i >= 0 && remain > 0; i--) {
                    int curIdx = maxCost[i][1];
                    int additional = Math.min(maxCost[i][0] - result[curIdx], remain);
                    result[curIdx] += additional;
                    remain -= additional;
                }
            }

            if (remain > 0) {
                sb.append("IMPOSSIBLE\n");
            } else {
                for (int i = 0; i < n; i++) {
                    sb.append(result[i]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}
