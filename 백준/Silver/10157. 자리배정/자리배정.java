import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();
        int K = scanner.nextInt();

        // 좌석 번호 K가 전체 좌석 수를 초과하는 경우
        if (K > C * R) {
            System.out.println(0);
            return;
        }

        int[][] seats = new int[R][C];
        int x = 0, y = 0; // 현재 위치
        int num = 1; // 현재 좌석 번호

        // 나선형 이동 방향: 위, 오른쪽, 아래, 왼쪽
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0; // 방향 인덱스

        while (num <= K) {
            seats[x][y] = num; // 좌석 번호 할당

            if (num == K) {
                System.out.println((x + 1) + " " + (y + 1));
                return;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위를 벗어나거나 이미 채워진 좌석인 경우 방향 전환
            if (nx < 0 || nx >= R || ny < 0 || ny >= C || seats[nx][ny] != 0) {
                dir = (dir + 1) % 4; // 방향 전환
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
            num++;
        }
    }
}
