import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Contest {
        int id;
        int[] scores;
        int submissions;
        int lastSubTime;

        public Contest(int id, int problemCnt) {
            this.id = id;
            this.scores = new int[problemCnt + 1];
            this.submissions = 0;
            this.lastSubTime = 0;
        }

        public int getTotalScore() {
            return Arrays.stream(scores).sum();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int tId = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Map<Integer, Contest> contestMap = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                contestMap.put(i, new Contest(i, k));
            }

            for (int time = 1; time <= m; time++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int problem = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                Contest contest = contestMap.get(id);
                contest.scores[problem] = Math.max(contest.scores[problem], score);
                contest.submissions++;
                contest.lastSubTime = time;
            }

            List<Contest> ranking = new ArrayList<>(contestMap.values());

            ranking.sort((a, b) -> {
                if (a.getTotalScore() != b.getTotalScore()) {
                    return b.getTotalScore() - a.getTotalScore();
                } else if (a.submissions != b.submissions) {
                    return a.submissions - b.submissions;
                } else {
                    return a.lastSubTime - b.lastSubTime;
                }
            });

            int rank = 1;
            for (int i = 0; i < ranking.size(); i++) {
                if (ranking.get(i).id == tId) {
                    rank = i + 1;
                    break;
                }
            }

            sb.append(rank + "\n");
        }
        System.out.println(sb);
    }
}