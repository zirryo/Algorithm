import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new List[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == -1) continue;
            tree[x].add(i);
        }

        System.out.println(dfs(0));
    }
    static int dfs(int node) {
        if (tree[node].isEmpty()) {
            return 0;
        }

        List<Integer> times = new ArrayList<>();
        for (int child : tree[node]) {
            times.add(dfs(child));
        }

        // 시간 역순으로 정렬 (가장 시간이 많이 걸리는 사람부터 전달하기 위함)
        Collections.sort(times, Collections.reverseOrder());

        int maxTime = 0;
        for (int i = 0; i < times.size(); i++) {
            maxTime = Math.max(maxTime, times.get(i) + i + 1);
        }
        return maxTime;
    }
}