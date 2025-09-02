import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] infected = new boolean[N + 1];
        int healthyCount = N;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int x = Integer.parseInt(st.nextToken());
                if (!infected[x]) {
                    infected[x] = true;
                    healthyCount--;
                }
            } else if (type == 2) {
                int x = Integer.parseInt(st.nextToken());
                if (infected[x]) {
                    infected[x] = false;
                    healthyCount++;
                }
            } else if (type == 3) {
                sb.append(healthyCount).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
