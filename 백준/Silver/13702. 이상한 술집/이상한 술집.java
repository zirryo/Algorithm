import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] capa;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        capa = new int[N];
        int max = -1;
        for (int i = 0; i < N; i++) {
            capa[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, capa[i]);
        }

        System.out.println(binarySearch(1, max));
    }
    private static long binarySearch(long l, long r) {
        int result = 0;

        while (l <= r) {
            long mid = (l + r) / 2;
            int tmp = 0;
            for (int juice : capa) {
                tmp += juice / mid;
            }

            if (tmp >= M) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return r;
    }
}