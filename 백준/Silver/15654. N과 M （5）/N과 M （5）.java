import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] seq;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();
        dfs(0);
        System.out.println(sb);
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        seq = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);
    }
    private static void dfs(int depth) {
        if(depth == M) {
            for(int i=0; i<M; i++) sb.append(seq[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                seq[depth] = nums[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
/* 백트래킹 알고리즘 (Backtracking Algorithm)
- 해를 찾는 도중 해가 아니어서 막히면, 되돌아가서 다시 해를 찾아가는 기법
- 최적화 문제와 결정 문제를 푸는 방법
-  DFS 등으로 모든 경우의 수를 탐색하는 과정에서, 조건문 등을 걸어 답이 절대로 될 수 없는 상황을 정의함.
 -> 탐색을 중지시킨 뒤 그 이전으로 돌아가서 다시 다른 경우를 탐색하게끔 구현함. (depth == M 조건)
 */