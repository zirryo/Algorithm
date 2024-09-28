import java.io.*;
import java.util.*;

public class Main {
    static char[][] board = new char[5][9];
    static boolean[] used = new boolean[12];
    static int[][] lines = {
            {0, 4, 1, 3, 2, 2, 3, 1},
            {0, 4, 1, 5, 2, 6, 3, 7},
            {1, 1, 2, 2, 3, 3, 4, 4},
            {1, 7, 2, 6, 3, 5, 4, 4},
            {1, 1, 1, 3, 1, 5, 1, 7},
            {3, 1, 3, 3, 3, 5, 3, 7}
    };
    static ArrayList<int[]> blanks = new ArrayList<>(); // 빈칸의 좌표들

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 'x') {
                    blanks.add(new int[]{i, j});
                } else if (board[i][j] != '.') {
                    used[board[i][j] - 'A'] = true;
                }
            }
        }

        dfs(0);
    }

    static boolean dfs(int idx) {
        if (idx == blanks.size()) {
            if (check()) {
                printStar();
                return true;
            }
            return false;
        }

        int[] pos = blanks.get(idx);
        int x = pos[0];
        int y = pos[1];

        for (int i = 0; i < 12; i++) {
            if (!used[i]) {
                used[i] = true;
                board[x][y] = (char) (i + 'A');
                if (dfs(idx + 1)) {
                    return true;
                }
                board[x][y] = 'x';
                used[i] = false;
            }
        }
        return false;
    }

    static boolean check() {
        for (int[] line : lines) {
            int sum = 0;
            for (int i = 0; i < line.length; i += 2) {
                sum += board[line[i]][line[i + 1]] - 'A' + 1;
            }
            if (sum != 26) return false;
        }
        return true;
    }

    static void printStar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(board[i]).append("\n");
        }
        System.out.print(sb);
    }
}
