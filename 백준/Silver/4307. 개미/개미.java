import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int l, N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            for (int j=0; j<N; j++) {
                arr[j] = Integer.parseInt(br.readLine());
            }
            int[] result = getMinTimeAndMaxTime();
            sb.append(String.format("%d %d\n", result[0], result[1]));
        }
        System.out.println(sb);
    }
    private static int[] getMinTimeAndMaxTime() {
        int min = 0;
        int max = 0;
        int mid = l / 2;
        for (int i = 0; i < N; i++) {
            if (arr[i] <= mid) {
                min = Math.max(min, arr[i]);
                max = Math.max(max, l - arr[i]);
            } else {
                min = Math.max(min, l - arr[i]);
                max = Math.max(max, arr[i]);
            }
        }
        return new int[]{min, max};
    }
}