import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer = 0;
    static int[][] dice;
    static int[] opposite = {5, 3, 4, 1, 2, 0}; // 각 면이 마주보는 면의 인덱스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dice = new int[N][6];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 6; i++) { // 1층 윗면의 인덱스
            int max = 0;
            for (int j = 0; j < 6; j++) { // 1층 옆면 중 가장 큰 값 고르기
                if (i == j || j == opposite[i]) continue; // 바닥면, 윗면은 후보에서 제외
                max = Math.max(max, dice[0][j]);
            }
            stackDice(1, dice[0][i], max);
        }

        System.out.println(answer);
    }
    private static void stackDice(int idx, int top, int sum) {
        if (idx == N) {
            answer = Math.max(answer, sum);
            return;
        }

        int bottomIdx = -1; // 바닥면의 인덱스
        for (int i = 0; i < 6; i++) {
            if (dice[idx][i] == top) {
                bottomIdx = i;
                break;
            }
        }

        int topIdx = opposite[bottomIdx]; // 윗면의 인덱스
        int maxSide = 0;

        for (int i = 0; i < 6; i++) {
            if (i == topIdx || i == bottomIdx) continue; // 바닥면, 윗면은 후보에서 제외
            maxSide = Math.max(maxSide, dice[idx][i]);
        }

        stackDice(idx + 1, dice[idx][topIdx], sum + maxSide);
    }
}