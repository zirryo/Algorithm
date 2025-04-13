import java.io.*;
import java.util.*;

public class Main {
    static class Day {
        int diff; // A - B
        public Day(int diff) {
            this.diff = diff;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int baseTaste = 0;
        List<Integer> diffs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            baseTaste += B;

            if (A > B) {
                diffs.add(A - B);
            }
        }

        int canUpgrade = (X - 1000 * N) / 4000;

        Collections.sort(diffs, Collections.reverseOrder());

        int extraTaste = 0;
        for (int i = 0; i < Math.min(canUpgrade, diffs.size()); i++) {
            extraTaste += diffs.get(i);
        }

        System.out.println(baseTaste + extraTaste);
    }
}
