import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 200; // 최대 2N
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[2 * N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2 * N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            boolean[] used = new boolean[2 * N];
            List<Long> discountPrices = new ArrayList<>();

            for (int i = 0; i < 2 * N; i++) {
                if (used[i]) continue;

                long discounted = arr[i];
                if ((discounted * 4) % 3 != 0) continue;

                long original = (discounted * 4) / 3;

                for (int j = i + 1; j < 2 * N; j++) {
                    if (!used[j] && arr[j] == original) {
                        used[i] = true;
                        used[j] = true;
                        discountPrices.add(discounted);
                        break;
                    }
                }
            }

            sb.append("Case #" + t + ":");
            for (long price : discountPrices) {
                sb.append(" " + price);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
