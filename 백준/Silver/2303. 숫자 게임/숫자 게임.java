import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cards = new int[n][5];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxScore = 0;
        int winner = 0;

        for (int i = 0; i < n; i++) {
            int currentMax = 0;

            for (int a = 0; a < 5; a++) {
                for (int b = a + 1; b < 5; b++) {
                    for (int c = b + 1; c < 5; c++) {
                        int sum = cards[i][a] + cards[i][b] + cards[i][c];
                        int score = sum % 10;
                        currentMax = Math.max(currentMax, score);
                    }
                }
            }

            if (currentMax >= maxScore) {
                maxScore = currentMax;
                winner = i + 1;
            }
        }

        System.out.println(winner);
    }
}
