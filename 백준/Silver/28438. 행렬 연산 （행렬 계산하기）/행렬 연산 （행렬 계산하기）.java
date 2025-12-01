import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        long[] row = new long[N];
        long[] col = new long[M];

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());

            if (type == 1) {
                row[idx] += v;
            } else {
                col[idx] += v;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(row[i] + col[j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
