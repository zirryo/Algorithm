import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        backTracking4(1,0);
        System.out.println(sb);
    }
    static void backTracking4(int cur, int depth) {
        if(depth == M) {
            for(int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=cur; i<=N; i++) {
            arr[depth] = i;
            backTracking4(i,depth  + 1);
        }
    }
}