import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] command = br.readLine().toCharArray();
        boolean[][][] visited = new boolean[n][n][2]; // 0 - 수직, 1 - 수평

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int r = 0;
        int c = 0;

        for (int i = 0; i < command.length; i++) {
            int dir = "UDLR".indexOf(command[i]);
            boolean vertical = (dir == 0 || dir == 1);
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;


            if (r >= 0 && r < n && c >= 0 && c < n) {
                if (vertical) {
                    visited[r][c][0] = true;
                } else {
                    visited[r][c][1] = true;
                }
            }

            if (vertical) {
                visited[nr][nc][0] = true;
            } else {
                visited[nr][nc][1] = true;
            }

            r = nr;
            c = nc;



        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j][0]) {
                    if (visited[i][j][1]) {
                        sb.append("+");
                    } else {
                        sb.append("|");
                    }
                } else if (visited[i][j][1]) {
                    sb.append("-");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
