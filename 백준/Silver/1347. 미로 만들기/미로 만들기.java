import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, -1, 0, 1}; // 0 - 아래, 1 - 왼쪽, 2 - 위, 3 - 오른쪽
        int size = 50;
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[][] map = new char[2 * size + 1][2 * size + 1]; // 맵의 정중앙에서 시작. 상하좌우로 50칸 이동 가능
        for (int i = 0; i < 2 * size + 1; i++) {
            Arrays.fill(map[i], '#');
        }
        int dir = 0; // 초기에 남쪽을 바라보고 서있음
        Pos R = new Pos(size, size, size);
        Pos C = new Pos(size, size, size);
        map[R.cur][C.cur] = '.';

        for (int i = 0; i < N; i++) {
            char com = str.charAt(i);

            if (com == 'F') {
                R.cur += dr[dir];
                C.cur += dc[dir];
                map[R.cur][C.cur] = '.';
                R.max = Math.max(R.max, R.cur);
                C.min = Math.min(C.min, C.cur);
                R.min = Math.min(R.min, R.cur);
                C.max = Math.max(C.max, C.cur);
            } else if (com == 'L') {
                dir = (dir + 3) % 4;
            } else if (com == 'R') {
                dir = (dir + 1) % 4;
            }
        }

        for (int r = R.min; r <= R.max; r++) {
            for (int c = C.min; c <= C.max; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static class Pos {
        int cur;
        int max;
        int min;

        public Pos(int cur, int max, int min) {
            this.cur = cur;
            this.max = max;
            this.min = min;
        }
    }
}
