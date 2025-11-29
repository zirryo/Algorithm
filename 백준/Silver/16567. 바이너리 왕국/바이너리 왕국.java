import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] dirty = new boolean[N + 2];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            dirty[i] = st.nextToken().equals("1");
        }

        int segments = 0;
        for (int i = 1; i <= N; i++) {
            if (dirty[i] && !dirty[i - 1]) {
                segments++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int q = 0; q < M; q++) {
            String line = br.readLine();

            if (line.equals("0")) {
                sb.append(segments).append('\n');
            } else {
                st = new StringTokenizer(line);
                st.nextToken();
                int i = Integer.parseInt(st.nextToken());

                if (dirty[i]) continue;

                boolean left = dirty[i - 1];
                boolean right = dirty[i + 1];

                if (!left && !right) segments++;
                else if (left && right) segments--;

                dirty[i] = true;
            }
        }

        System.out.print(sb);
    }
}
