import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];

        int top = N;
        int bottom = 0;
        int left = M;
        int right = 0;
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '#') {
                    top = Math.min(i, top);
                    bottom = Math.max(i, bottom);
                    left = Math.min(j, left);
                    right = Math.max(j, right);
                }
            }
        }

        int midX = (left + right) / 2;
        int midY = (top + bottom) / 2;

        if (board[midY][left] == '.') {
            System.out.println("LEFT");
        } else if (board[midY][right] == '.') {
            System.out.println("RIGHT");
        } else if (board[top][midX] == '.') {
            System.out.println("UP");
        } else {
            System.out.println("DOWN");
        }
    }
}