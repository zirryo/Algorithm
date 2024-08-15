import java.util.Scanner;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // U, D, L, R 순
    static char[] dirChars = {'U', 'R', 'D', 'L'};
    static int startX, startY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = scanner.next().toCharArray();
        }

        startX = scanner.nextInt() - 1;
        startY = scanner.nextInt() - 1;

        char bestDir = ' ';
        int maxTime = 0;

        for (int i = 0; i < 4; i++) {
            int time = simulate(startX, startY, i);
            if (time == -1) {
                System.out.println(dirChars[i]);
                System.out.println("Voyager");
                return;
            }
            if (time > maxTime) {
                maxTime = time;
                bestDir = dirChars[i];
            }
        }

        System.out.println(bestDir + "\n" + maxTime);
    }

    static int simulate(int x, int y, int dir) {
        boolean[][][] visited = new boolean[N][M][4];
        int time = 0;

        while (true) {
            if (visited[x][y][dir]) {
                return -1;  // 무한루프 발생
            }
            visited[x][y][dir] = true;
            time++;

            int nx = x + directions[dir][0];
            int ny = y + directions[dir][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 'C') {
                break;  // 맵 밖으로 나가거나 장애물을 만난 경우
            }

            if (map[nx][ny] == '/') {
                if (dir == 0) dir = 1;
                else if (dir == 1) dir = 0;
                else if (dir == 2) dir = 3;
                else dir = 2;
            } else if (map[nx][ny] == '\\') {
                if (dir == 0) dir = 3;
                else if (dir == 1) dir = 2;
                else if (dir == 2) dir = 1;
                else dir = 0;
            }

            x = nx;
            y = ny;
        }

        return time;
    }

}
