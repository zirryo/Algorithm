import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[][] floor;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        floor = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                floor[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    countTile(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void countTile(int x, int y) {
        visited[x][y] = true;
        char current = floor[x][y];

        if (current == '-') {
            int ny = y + 1;
            while (ny < M && floor[x][ny] == current && !visited[x][ny]) {
                visited[x][ny] = true;
                ny++;
            }
        } else if (current == '|') {
            int nx = x + 1;
            while (nx < N && floor[nx][y] == current && !visited[nx][y]) {
                visited[nx][y] = true;
                nx++;
            }
        }
    }
}
