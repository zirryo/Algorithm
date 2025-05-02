import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String target;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        N = Integer.parseInt(br.readLine());

        int[] cost = new int[N];
        String[] titles = new String[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            titles[i] = st.nextToken();
        }

        for (int bit = 1; bit < (1 << N); bit++) {
            int[] charCount = new int[26];
            int totalCost = 0;

            for (int i = 0; i < N; i++) {
                if ((bit & (1 << i)) != 0) {
                    totalCost += cost[i];
                    for (char c : titles[i].toCharArray()) {
                        charCount[c - 'A']++;
                    }
                }
            }

            if (canFormTarget(charCount)) {
                minCost = Math.min(minCost, totalCost);
            }
        }

        System.out.println(minCost == Integer.MAX_VALUE ? -1 : minCost);
    }

    static boolean canFormTarget(int[] charCount) {
        int[] need = new int[26];
        for (char c : target.toCharArray()) {
            need[c - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] < need[i]) return false;
        }
        return true;
    }
}
