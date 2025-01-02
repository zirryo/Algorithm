import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int num = 1;
    static String[][] original;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        original = new String[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                original[i][j] = st.nextToken();
            }
        }

        smallSquare(3, 3, false);
        System.out.println(sb);

    }
    static void smallSquare(int r, int c, boolean flag) {
        List<Goal> goals = new ArrayList<Goal>();
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (i == r + 1 && j == c + 1) continue;
                goals.add(new Goal(original[i][j], i, j));
            }
        }

        Collections.sort(goals);

        if (flag) {
            writeGoals(goals, num++, original[r+1][c+1]);
        } else {
            for (Goal g : goals) {
                smallSquare((g.r - 3) * 3, (g.c - 3) * 3, true);
            }
        }
    }
    static void writeGoals(List<Goal> goals, int num, String semiGoal) {
        sb.append(String.format("#%d. %s\n", num, semiGoal));

        for (int i = 0; i < goals.size(); i++) {
            sb.append(String.format("#%d-%d. %s\n", num, i+1, goals.get(i).name));
        }
    }
    static class Goal implements Comparable<Goal> {
        String name;
        int r;
        int c;

        public Goal(String name, int r, int c) {
            this.name = name;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Goal goal) {
            return name.compareTo(goal.name);
        }
    }
}
