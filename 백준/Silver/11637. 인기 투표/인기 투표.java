import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] votes = new int[N + 1];
            int totalVotes = 0, maxVotes = 0, winner = 0;
            boolean tie = false;

            for (int i = 1; i <= N; i++) {
                votes[i] = Integer.parseInt(br.readLine());
                totalVotes += votes[i];

                if (votes[i] > maxVotes) {
                    maxVotes = votes[i];
                    winner = i;
                    tie = false;
                } else if (votes[i] == maxVotes) {
                    tie = true;
                }
            }

            if (tie) {
                sb.append("no winner\n");
            } else {
                boolean majority = maxVotes > totalVotes / 2;
                sb.append(majority ? "majority winner " : "minority winner ").append(winner).append("\n");
            }
        }

        System.out.print(sb);
    }
}
