import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        snowball(0, 0, 1);
        System.out.println(result);

    }
    private static void snowball(int idx, int cnt, int size) {
        if (cnt == M || idx == N) {
            result = Math.max(result, size);
            return;
        }

        if (cnt < M) {
            if (idx < N) snowball(idx + 1, cnt + 1, size + arr[idx + 1]);
            if (idx < N-1) snowball(idx + 2, cnt + 1, size/2 + arr[idx + 2]);
        }

    }
}