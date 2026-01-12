import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[] stations = new int[n];
            for (int i = 0; i < n; i++) {
                stations[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(stations);

            boolean possible = true;

            for (int i = 0; i < n - 1; i++) {
                if (stations[i + 1] - stations[i] > 200) {
                    possible = false;
                    break;
                }
            }

            if (2 * (1422 - stations[n - 1]) > 200) {
                possible = false;
            }

            sb.append(possible ? "POSSIBLE\n" : "IMPOSSIBLE\n");
        }

        System.out.println(sb);
    }
}