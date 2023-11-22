import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] stick;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        stick = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            stick[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(stick);
        System.out.println(binarySearch());
    }
    private static int binarySearch() {
        int l = 1;
        int r = stick[M-1];
        int result = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            int tmp = 0;
            for (int len : stick) {
                tmp += len / mid;
            }

            if (tmp >= N) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return result;
    }
}