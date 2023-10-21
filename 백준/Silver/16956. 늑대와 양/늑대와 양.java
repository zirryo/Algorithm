import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().replace('.', 'D').toCharArray();
        }
        boolean flag = true;
        Outer:
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'W') {
                    if (!nearSheep(i, j)) {
                        flag = false;
                        break Outer;
                    }
                }
            }
        }

        if (flag) {
            sb.append("1\n");
            for (int i = 0; i < R; i++) {
                sb.append(String.valueOf(map[i])).append("\n");
            }
        } else {
            sb.append(0);
        }
        System.out.println(sb);
    }
    private static boolean nearSheep(int r, int c) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int nr = dr[i] + r;
            int nc = dc[i] + c;
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (map[nr][nc] == 'S') return false;
        }
        return true;
    }
}
class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}