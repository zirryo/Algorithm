import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine().trim());
            long N = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            long AB = A * B;
            long BC = B * C;
            long CA = C * A;

            long sNum = AB + BC + CA;
            long ABC = A * B * C;

            long numerator = N * ABC;

            if (sNum == 0) {
                sb.append("-1\n");
                continue;
            }

            if (numerator % sNum != 0) {
                sb.append("-1\n");
                continue;
            }

            long M = numerator / sNum;

            if (M % A != 0 || M % B != 0 || M % C != 0) {
                sb.append("-1\n");
                continue;
            }

            long K = M - N;
            if (K < 0) {
                sb.append("-1\n");
            } else {
                sb.append(K).append('\n');
            }
        }

        System.out.print(sb);
    }
}
