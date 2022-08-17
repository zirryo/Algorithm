import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N];

        backTracking(0);
        System.out.println(sb);

    }
    static void backTracking(int depth) {
        if(depth == M) {
            for (int k : arr) {
                sb.append(k + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}