import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, ans;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        sb = new StringBuilder();
        makeSeries(0);
        System.out.println(sb);
    }
    private static void makeSeries(int depth) {
        if (depth == M) {
            printSeries();
            return;
        }
        for (int i = 0; i < N; i++) {
            ans[depth] = arr[i];
            makeSeries(depth + 1);
        }
    }
    private static void printSeries() {
        for (int x : ans) {
            sb.append(x).append(" ");
        }
        sb.append("\n");
    }
}