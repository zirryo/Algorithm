import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String yeondu = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] teams = new String[N];
        for (int i = 0; i < N; i++) {
            teams[i] = br.readLine();
        }

        String answer = null;
        int maxScore = -1;

        for (String team : teams) {
            int score = calcScore(yeondu, team);
            if (score > maxScore || (score == maxScore && team.compareTo(answer) < 0)) {
                maxScore = score;
                answer = team;
            }
        }

        System.out.println(answer);
    }

    private static int calcScore(String yeondu, String team) {
        int L = 0, O = 0, V = 0, E = 0;
        String combined = yeondu + team;

        for (int i = 0; i < combined.length(); i++) {
            char ch = combined.charAt(i);
            if (ch == 'L') L++;
            else if (ch == 'O') O++;
            else if (ch == 'V') V++;
            else if (ch == 'E') E++;
        }

        return ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
    }
}
