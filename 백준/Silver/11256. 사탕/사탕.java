import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] cap = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int R = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                cap[i] = R * C;
            }

            Arrays.sort(cap);
            int count = 0;

            for (int i = N - 1; i >= 0; i--) {
                J -= cap[i];
                count++;
                if (J <= 0) break;
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
