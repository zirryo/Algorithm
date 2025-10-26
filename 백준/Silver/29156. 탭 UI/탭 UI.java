import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] len = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine().trim();
            len[i] = Long.parseLong(s);
        }

        long L = Long.parseLong(br.readLine().trim());
        int Q = Integer.parseInt(br.readLine().trim());

        double[] leftPos = new double[N + 1];
        leftPos[1] = 0.0;
        for (int i = 2; i <= N; i++) {
            leftPos[i] = leftPos[i - 1] + len[i - 1];
        }

        double S = 0;
        for (int i = 1; i <= N; i++) S += len[i];

        double maxX = Math.max(0.0, S - L);
        double screenCenter = L / 2.0;

        StringBuilder sb = new StringBuilder();
        for (int qi = 0; qi < Q; qi++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());

            double tabCenter = leftPos[idx] + len[idx] / 2.0;
            double xt = tabCenter - screenCenter;

            double xf = xt;
            if (xf < 0) xf = 0.0;
            if (xf > maxX) xf = maxX;

            double truncated = Math.floor(xf * 100.0) / 100.0;

            sb.append(String.format("%.2f", truncated)).append('\n');
        }

        System.out.print(sb);
    }
}
