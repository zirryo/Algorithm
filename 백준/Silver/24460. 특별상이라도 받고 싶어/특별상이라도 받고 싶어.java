import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int[][] board;

    public static int findWinner(int x, int y, int size) {
        if (size == 1) {
            return board[x][y];
        }

        int half = size / 2;

        int[] winners = new int[4];
        winners[0] = findWinner(x, y, half); // 왼쪽 위
        winners[1] = findWinner(x, y + half, half); // 오른쪽 위
        winners[2] = findWinner(x + half, y, half); // 왼쪽 아래
        winners[3] = findWinner(x + half, y + half, half); // 오른쪽 아래

        Arrays.sort(winners);
        return winners[1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findWinner(0, 0, N));
    }
}
