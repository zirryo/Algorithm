import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int maxSejun = 0;
            for (int i = 0; i < N; i++) {
                maxSejun = Math.max(maxSejun, Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            int maxSebin = 0;
            for (int i = 0; i < M; i++) {
                maxSebin = Math.max(maxSebin, Integer.parseInt(st.nextToken()));
            }

            if (maxSejun >= maxSebin) {
                sb.append("S\n");
            } else {
                sb.append("B\n");
            }
        }

        System.out.print(sb);
    }
}
