import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map = new char[5][5];
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[] r = new int[25], c = new int[25];
    static int[] pick = new int[7];
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < 25; i++) {
            r[i] = i / 5;
            c[i] = i % 5;
        }
        pickSeven(0, 0);
        System.out.println(result);
    }
    private static void pickSeven(int depth, int idx) {
        if (depth == 7) {
            validCheck();
            return;
        }

        for (int i = idx; i < 25; i++) {
            pick[depth] = i;
            pickSeven(depth + 1, i + 1);
        }
    }
    private static void validCheck() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[7];
        visited[0] = true;
        q.add(pick[0]);
        int cntS = 0;
        int connected = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (map[r[cur]][c[cur]] == 'S') cntS++;

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < 7; j++) {
                    if (visited[j] || r[cur] + dr[i] != r[pick[j]] || c[cur] + dc[i] != c[pick[j]]) {
                        continue;
                    }
                    visited[j] = true;
                    q.add(pick[j]);
                    connected++;
                }
            }
        }

        if (cntS >= 4 && connected == 7) {
            result++;
        }

    }
}