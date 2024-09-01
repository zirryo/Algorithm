import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] mines = new char[N][N];
        char[][] opened = new char[N][N];

        for (int i = 0; i < N; i++) {
            mines[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            opened[i] = br.readLine().toCharArray();
        }

        boolean boom = false;

        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        char[][] result = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (opened[i][j] == 'x') {
                    if (mines[i][j] == '*') {
                        boom = true;
                    }

                    int mineCount = 0;
                    for (int d = 0; d < 8; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && mines[nx][ny] == '*') {
                            mineCount++;
                        }
                    }

                    result[i][j] = (char) (mineCount + '0');
                } else {
                    result[i][j] = '.';
                }
            }
        }

        if (boom) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mines[i][j] == '*') {
                        result[i][j] = '*';
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}