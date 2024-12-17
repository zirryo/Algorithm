import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N;
    static Set<Integer> result = new HashSet<>();
    static int[] arr = {1, 5, 10, 50};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(0, 0, 0);
        System.out.println(result.size());
    }
    static void dfs(int depth, int sum, int idx) {
        if (depth == N) {
            result.add(sum);
            return;
        }

        for (int i = idx; i < 4; i++) {
            dfs(depth + 1, sum + arr[i], i);
        }
    }
}
