import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M, result = 0;
    static int[] scoreArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        scoreArr = new int[6];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                scoreArr[i * 3 + j] = Integer.parseInt(st.nextToken());
            }
        }

        playSpyGame(0, 0, 0);
        System.out.println(result);
    }
    private static void playSpyGame(int totalScore, int prevPos, int days) {
        if (days == N) {
            if (totalScore >= M) result++;
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (days == 0 || i % 3 != prevPos) {
                playSpyGame(totalScore + scoreArr[i], i % 3, days + 1);
            } else {
                playSpyGame(totalScore + scoreArr[i] / 2, i % 3, days + 1);
            }
        }
    }
}