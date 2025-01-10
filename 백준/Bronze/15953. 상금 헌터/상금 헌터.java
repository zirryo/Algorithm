import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[][] PRIZE_A = {
            {1, 500_0000},
            {3, 300_0000},
            {6, 200_0000},
            {10, 50_0000},
            {15, 30_0000},
            {21, 10_0000}
    };

    private static final int[][] PRIZE_B = {
            {1, 512_0000},
            {3, 256_0000},
            {7, 128_0000},
            {15, 64_0000},
            {31, 32_0000}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getPrize(a, PRIZE_A) + getPrize(b, PRIZE_B)).append("\n");
        }

        System.out.println(sb);
    }

    private static int getPrize(int rank, int[][] prizeTable) {
        if (rank == 0) return 0;

        for (int[] prize : prizeTable) {
            if (rank <= prize[0]) {
                return prize[1];
            }
        }

        return 0;
    }
}
