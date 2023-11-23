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
        int max = -1;
        for (int i = 0; i < M; i++) {
            stick[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, stick[i]);
        }

        System.out.println(binarySearch(1, max));
    }
    private static int binarySearch(int l, int r) {
        int result = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            int tmp = 0;
            for (int jewel : stick) {
                tmp += jewel / mid;
                if (jewel % mid != 0) {
                    tmp++; // 모든 보석을 나누어 주어야 하기 때문에 남은 보석 처리
                }
            }

            if (tmp > N) {
                l = mid + 1;
            } else {
                r = mid - 1;
                result = mid;
            }

        }

        return result;
    }
}