import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= K; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int[] scores = new int[N];

            for (int j = 0; j < N; j++) {
                scores[j] = Integer.parseInt(input[j + 1]);
            }

            Arrays.sort(scores);

            int maxScore = scores[N - 1];
            int minScore = scores[0];
            int largestGap = 0;

            for (int j = 1; j < N; j++) {
                largestGap = Math.max(largestGap, scores[j] - scores[j - 1]);
            }

            sb.append("Class ").append(i).append("\n");
            sb.append("Max ").append(maxScore).append(", Min ").append(minScore).append(", Largest gap ").append(largestGap).append("\n");
        }

        System.out.println(sb);
    }
}
