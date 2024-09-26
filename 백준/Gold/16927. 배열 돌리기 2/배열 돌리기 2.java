import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 그룹별로 회전하기
        int groupCount = Math.min(N, M) / 2;
        for (int group = 0; group < groupCount; group++) {
            rotateGroup(group);
        }

        // 배열 출력하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    // 각 그룹을 R번 회전시키는 함수
    static void rotateGroup(int group) {
        int x1 = group, y1 = group;
        int x2 = N - group - 1, y2 = M - group - 1;

        int len = 2 * (x2 - x1 + y2 - y1);
        int[] elements = new int[len];
        int index = 0;

        // 윗줄 (왼쪽 -> 오른쪽)
        for (int i = y1; i < y2; i++) elements[index++] = map[x1][i];
        // 오른쪽 줄 (위쪽 -> 아래쪽)
        for (int i = x1; i < x2; i++) elements[index++] = map[i][y2];
        // 아랫줄 (오른쪽 -> 왼쪽)
        for (int i = y2; i > y1; i--) elements[index++] = map[x2][i];
        // 왼쪽 줄 (아래쪽 -> 위쪽)
        for (int i = x2; i > x1; i--) elements[index++] = map[i][y1];

        int rotateIndex = R % len;

        index = 0;
        // 윗줄 (왼쪽 -> 오른쪽)
        for (int i = y1; i < y2; i++) map[x1][i] = elements[(rotateIndex + index++) % len];
        // 오른쪽 줄 (위쪽 -> 아래쪽)
        for (int i = x1; i < x2; i++) map[i][y2] = elements[(rotateIndex + index++) % len];
        // 아랫줄 (오른쪽 -> 왼쪽)
        for (int i = y2; i > y1; i--) map[x2][i] = elements[(rotateIndex + index++) % len];
        // 왼쪽 줄 (아래쪽 -> 위쪽)
        for (int i = x2; i > x1; i--) map[i][y1] = elements[(rotateIndex + index++) % len];
    }
}
