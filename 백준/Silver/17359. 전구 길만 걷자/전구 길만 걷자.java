import java.io.*;

public class Main {
    static int N;
    static String[] bundles;
    static int minChanges = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bundles = new String[N];
        for (int i = 0; i < N; i++) {
            bundles[i] = br.readLine();
        }

        visited = new boolean[N];
        order = new int[N];

        permu(0);

        System.out.println(minChanges);
    }

    static void permu(int depth) {
        if (depth == N) {
            countChange();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                permu(depth + 1);
                visited[i] = false;
            }
        }
    }

    static void countChange() {
        int currentChanges = 0;

        for (int i = 0; i < N; i++) {
            String s = bundles[order[i]];
            for (int j = 0; j < s.length() - 1; j++) {
                if (s.charAt(j) != s.charAt(j + 1)) {
                    currentChanges++;
                }
            }
        }

        for (int i = 0; i < N - 1; i++) {
            String currentBundle = bundles[order[i]];
            String nextBundle = bundles[order[i + 1]];
            
            if (currentBundle.charAt(currentBundle.length() - 1) != nextBundle.charAt(0)) {
                currentChanges++;
            }
        }

        minChanges = Math.min(minChanges, currentChanges);
    }
}