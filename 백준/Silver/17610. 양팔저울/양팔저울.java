import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static int[] weight;
    static int N;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        int maxWeight = 0;
        for (int x : weight) {
            maxWeight += x;
        }

        System.out.println(maxWeight - set.size());
    }

    static void dfs(int idx, int curWeight) {
        if (idx == N) {
            if (curWeight > 0) set.add(curWeight);
            return;
        }

        dfs(idx + 1, curWeight);
        dfs(idx + 1, curWeight - weight[idx]);
        dfs(idx + 1, curWeight + weight[idx]);
    }
}
