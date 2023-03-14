import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, val;
    static int[] arr;
    static boolean[] visited, assigned;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
            val = 0;
            visited = new boolean[N+1];
            assigned = new boolean[N+1];
            for(int i=1; i<=N; i++) {
                if(assigned[i]) continue;
                dfs(i);
            }
            sb.append(N-val).append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int x) {
        if(assigned[x]) return; // 이미 검사 완료된 경우
        if(visited[x]) {
            assigned[x] = true;
            val++; // 팀 구성을 한 인원으로 집계
        }
        visited[x] =true; // 방문 체크
        dfs(arr[x]);
        assigned[x] = true; // 검사 완료
        visited[x] = false; // 초기화
    }
}