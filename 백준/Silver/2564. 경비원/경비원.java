import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int C, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[K];
        int result = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int tempDir = Integer.parseInt(st.nextToken());
            int tempDist = Integer.parseInt(st.nextToken());
            arr[i] = calDist(tempDir, tempDist);
        }

        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());
        int x = calDist(dir, dist);

        for (int cur : arr) {
            int diff = Math.abs(x - cur);

            if (diff > C + R) result += 2 * (C + R) - diff;
            else result += diff;
        }
        System.out.println(result);
    }
    private static int calDist(int curDir, int curDist) {
        switch (curDir) {
            case 1 : {
                return curDist;
            }
            case 2 : {
                return  2 * C + R - curDist;
            }
            case 3 : {
                return 2 * (C + R) - curDist;
            }
            case 4 : {
                return C + curDist;
            }
        }
        return 0;
    }
}