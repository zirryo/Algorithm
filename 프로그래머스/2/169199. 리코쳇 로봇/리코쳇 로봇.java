import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    static class Node {
        int r, c, moves;

        Node(int r, int c, int moves) {
            this.r = r;
            this.c = c;
            this.moves = moves;
        }
    }

    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();

        int startR = -1, startC = -1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r].charAt(c) == 'R') {
                    startR = r;
                    startC = c;
                    break;
                }
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(new Node(startR, startC, 0));
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (board[current.r].charAt(current.c) == 'G') {
                return current.moves;
            }

            for (int i = 0; i < 4; i++) {
                int nr = current.r;
                int nc = current.c;

                while (true) {
                    int nextR = nr + dr[i];
                    int nextC = nc + dc[i];

                    if (nextR < 0 || nextR >= rows || nextC < 0 || nextC >= cols || board[nextR].charAt(nextC) == 'D') {
                        break;
                    }

                    nr = nextR;
                    nc = nextC;
                }

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new Node(nr, nc, current.moves + 1));
                }
            }
        }

        return -1;
    }
}