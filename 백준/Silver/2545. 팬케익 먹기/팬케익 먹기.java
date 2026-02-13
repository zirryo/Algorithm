import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String line = br.readLine();
            while (line != null && line.isEmpty()) line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            long[] L = new long[3];
            L[0] = Long.parseLong(st.nextToken());
            L[1] = Long.parseLong(st.nextToken());
            L[2] = Long.parseLong(st.nextToken());
            long D = Long.parseLong(st.nextToken());

            Arrays.sort(L);

            long diff1 = L[2] - L[1];
            long cut1 = Math.min(D, diff1);
            L[2] -= cut1;
            D -= cut1;


            if (D > 0) {
                long diff2 = L[1] - L[0];
                long cut2 = Math.min(D / 2, diff2);
                L[2] -= cut2;
                L[1] -= cut2;
                D -= (cut2 * 2);

                if (D == 1) {
                    L[1]--;
                    D--;
                }
            }

            if (D > 0) {
                long sub = D / 3;
                int rem = (int)(D % 3);
                L[0] -= sub;
                L[1] -= sub;
                L[2] -= sub;
                for (int i = 0; i < rem; i++) {
                    L[2 - i]--;
                }
            }

            long result = L[0] * L[1] * L[2];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}