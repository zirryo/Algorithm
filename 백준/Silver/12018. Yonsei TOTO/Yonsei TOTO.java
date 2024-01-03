import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] cost = new int[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[] mileage = new int[P];

            st = new StringTokenizer(br.readLine());
            for (int j=0; j<P; j++) {
                mileage[j] = Integer.parseInt(st.nextToken());
            }

            cost[i] = getCutLine(P, L, mileage);
        }
        Arrays.sort(cost);

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (M >= cost[i]) {
                M -= cost[i];
                result++;
            } else {
                break;
            }
        }
        System.out.println(result);
    }
    private static int getCutLine(int P, int L, int[] mileage) {
        if (P < L) return 1;
        Arrays.sort(mileage);
        return mileage[P-L];
    }
}