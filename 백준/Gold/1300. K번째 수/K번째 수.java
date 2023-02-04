import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, K;
    public static void main(String[] args) throws IOException {
        init();
        long result = getNumK();
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
    }

    private static long getNumK() {
        long l = 1;
        long r = K; // r의 최댓값은 K

        while(l < r) { // 임의의 수 x(mid) 보다 작거나 같은 수의 개수를 카운트 하여 K와 비교하며 탐색
            long mid = (l + r) / 2;
            long cnt = 0;

            for(int i=1; i<=N; i++) {
                cnt += Math.min(mid/i, N);
            }

            if(K <= cnt) r = mid; // Lower Bound(원하는 값 이상이 처음 나오는 위치를 찾음)
            else l = mid + 1;
        }

        return l;
    }
}