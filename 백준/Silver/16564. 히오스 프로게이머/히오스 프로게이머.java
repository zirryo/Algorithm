import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int r = 1_000_000_001;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            r = Math.min(r, arr[i]);
        }
        int l = r;
        r += M;

        while (l <= r) {
            int mid = (l + r) / 2;
            long total = M;
            for (int level : arr) {
                if (level < mid) {
                    total -= (mid - level);
                }
            }

            if (total < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(r);
    }
}