import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (P-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] original = new int[N];
            int count = 0;
            while (count < N) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    original[count++] = Integer.parseInt(st.nextToken());
                }
            }

            int[] sorted = original.clone();
            Arrays.sort(sorted);

            int sIdx = 0;
            for (int i = 0; i < N; i++) {
                if (original[i] == sorted[sIdx]) {
                    sIdx++;
                }
            }

            sb.append(K + " " + (N - sIdx)).append("\n");
        }
        System.out.println(sb);
    }
}