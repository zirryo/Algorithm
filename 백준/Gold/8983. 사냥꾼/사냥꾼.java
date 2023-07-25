import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M, N, L;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[M];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (binarySearch(x, y)) result++;
        }
        System.out.println(result);
    }
    private static boolean binarySearch(int x, int y) {
        if (y > L) return false;

        int l = 0;
        int r = M - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int dist = Math.abs(arr[mid] - x) + y;

            if (dist <= L) return true;

            if (x >= arr[mid]) l = mid + 1;
            else r = mid - 1;
        }

        return false;
    }
}