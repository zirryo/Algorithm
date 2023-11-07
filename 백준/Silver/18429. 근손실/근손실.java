import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] gain, gainIdx;
    static int N, M, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;
        visited = new boolean[N];
        gain = new int[N];
        gainIdx = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) gain[i] = Integer.parseInt(st.nextToken());
        permutation(0);
        System.out.println(result);
    }
    private static void permutation(int depth) {
        if (depth == N) {
            workout();
        } else {
            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                gainIdx[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
    private static void workout() {
        int muscle = 0;
        for (int i=0; i<N; i++) {
            muscle += gain[gainIdx[i]];
            muscle -= M;
            if (muscle < 0) return;
        }
        result++;
    }
}