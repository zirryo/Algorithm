// 중복순열 활용
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        backTracking3(0);
        System.out.println(sb);

    }
    static void backTracking3(int depth) {
        if(depth == M) {
            for(int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=N; i++) {
            arr[depth] = i;
            backTracking3(depth + 1);
        }
    }
}
