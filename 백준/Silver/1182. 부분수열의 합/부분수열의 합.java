import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static boolean[] isVisited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0, 0);
        System.out.println(result);

    }

    static void dfs(int idx, int sum, int depth) {
        if(idx == N) {
            if(depth != 0 && sum == S) result++; // 공집합 제외
            return;
        }
        
        dfs(idx+1, sum+arr[idx], depth+1);
        dfs(idx+1, sum, depth);
    }
}