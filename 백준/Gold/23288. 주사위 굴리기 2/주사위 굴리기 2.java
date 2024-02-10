import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, r = 0, c = 0, dir = 0, result = 0;
    static int[] dice = {0, 1, 2, 3, 4, 5, 6}; //  1-윗면 2-뒷면 3-오른쪽면 4-왼쪽면 5-앞면 6-바닥
    static int[][] roll = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 동 > 남 > 서 > 북
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        while (K-- > 0) {
            playDice();
        }

        System.out.println(result);
    }
    private static void playDice() {
        int tempR = r + roll[dir][0];
        int tempC = c + roll[dir][1];


        if(!inRange(tempR, tempC)) { // 맵 밖으로 이동한다면 반대 방향으로 이동
            tempR = r - roll[dir][0];
            tempC = c - roll[dir][1];
            dir = (dir + 2) % 4;
        }

        r = tempR;
        c = tempC;
        int temp = dice[1];

        switch (dir) {
            case 0: { // 동
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
                break;
            }
            case 1: { // 남
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
                break;
            }
            case 2: { // 서
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
                break;
            }
            case 3: { // 북
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
                break;
            }
        }

        bfs();

        if (dice[6] > map[r][c]) {
            dir = (dir + 1) % 4;
        } else if (dice[6] < map[r][c]) {
            dir = (dir + 3) % 4;
        }
    }
    private static void bfs() {
        int cnt = 0;
        int target = map[r][c];

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        visited[r][c] = true;
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            cnt++;
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = cur[0] + roll[i][0];
                int nextC = cur[1] + roll[i][1];

                if (inRange(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == target) {
                    q.add(new int[]{nextR, nextC});
                    visited[nextR][nextC] = true;
                }
            }
        }

        result += cnt * target;
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}