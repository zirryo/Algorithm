import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int l = 0, r = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (r < arr[i]) r = arr[i];
        }

        System.out.println(binarySearch(l, r));
    }
    private static int binarySearch(int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (divideSection(mid) <= M) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
    private static int divideSection(int mid) {
        int cnt = 1;
        int min = 10000;
        int max = 0;

        for (int i=0; i<N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (max - min > mid) {
                cnt++;
                min = 10000;
                max = 0;
                i--;
            }
        }
        return cnt;
    }
}