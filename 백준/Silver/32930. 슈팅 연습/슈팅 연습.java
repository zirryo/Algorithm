import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<int[]> targets = new ArrayList<int[]>();
    static int curX = 0, curY = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int totalScore = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            targets.add(new int[]{x, y});
        }

        for (int i = 0; i < M; i++) {
            totalScore += getScore();
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            targets.add(new int[]{x, y});
        }

        System.out.println(totalScore);
    }
    private static int getScore() {
        int score = 0;
        int nextIdx = -1;

        for (int i = 0; i < targets.size(); i++) {
            int[] target = targets.get(i);
            int curScore = calculateScore(target);
            if (curScore > score) {
                score = curScore;
                nextIdx = i;
            }
        }
        curX = targets.get(nextIdx)[0];
        curY = targets.get(nextIdx)[1];
        targets.remove(nextIdx);
        return score;

    }
    private static int calculateScore(int[] target) {
        return (int) (Math.pow(Math.abs(target[0] - curX), 2) + Math.pow(Math.abs(target[1] - curY), 2));
    }
}
