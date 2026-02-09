import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int count = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int d = 0; d < 8; d++) {
                    if (isMBTI(r, c, d)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    static boolean isMBTI(int r, int c, int d) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[d] * i;
            int nc = c + dc[d] * i;

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) return false;
            sb.append(board[nr][nc]);
        }

        String s = sb.toString();

        if (s.charAt(0) != 'E' && s.charAt(0) != 'I') return false;
        if (s.charAt(1) != 'S' && s.charAt(1) != 'N') return false;
        if (s.charAt(2) != 'T' && s.charAt(2) != 'F') return false;
        if (s.charAt(3) != 'J' && s.charAt(3) != 'P') return false;

        return true;
    }
}