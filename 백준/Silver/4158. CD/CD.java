import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            int[] sang = new int[N];
            int[] sun = new int[M];

            for (int i = 0; i < N; i++) {
                sang[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M; i++) {
                sun[i] = Integer.parseInt(br.readLine());
            }

            int i = 0, j = 0, count = 0;
            while (i < N && j < M) {
                if (sang[i] == sun[j]) {
                    count++;
                    i++;
                    j++;
                } else if (sang[i] < sun[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
