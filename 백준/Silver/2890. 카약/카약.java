import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] teamDistances = new int[10];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = line.charAt(j);
                if (c >= '1' && c <= '9') {
                    int team = c - '0';
                    teamDistances[team] = C - j;
                }
            }
        }

        List<int[]> teamRankings = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            teamRankings.add(new int[]{i, teamDistances[i]});
        }

        teamRankings.sort((a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int[] ranks = new int[10];
        int rank = 1;
        for (int i = 0; i < teamRankings.size(); i++) {
            if (i > 0 && teamRankings.get(i)[1] > teamRankings.get(i - 1)[1]) {
                rank++;
            }
            ranks[teamRankings.get(i)[0]] = rank;
        }

        for (int i = 1; i <= 9; i++) {
            System.out.println(ranks[i]);
        }
    }
}
