import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, series;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        series = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        makeSeries(0, 0);
        System.out.println(sb);
    }
    private static void makeSeries(int depth, int idx) {
        if (depth == M) {
            for (int x : series) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        } else {
            int prev = -1;
            for (int i = idx; i < N; i++) {
                if (prev == arr[i]) continue;
                series[depth] = arr[i];
                makeSeries(depth+1, i);
                prev = arr[i];
            }
        }
    }
}