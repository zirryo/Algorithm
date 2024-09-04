import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        StringBuilder[] result = new StringBuilder[N];
        for (int i = 0; i < N; i++) {
            result[i] = new StringBuilder();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != '.') {
                    result[i].append('*');
                } else {
                    int mineCount = 0;
                    for (int d = 0; d < 8; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != '.') {
                            mineCount += map[nx][ny] - '0';
                        }
                    }
                    if(mineCount >= 10) result[i].append('M');
                    else result[i].append(mineCount);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}
