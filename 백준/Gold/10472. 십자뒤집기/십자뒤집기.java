import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static final int SIZE = 3;
    static final int[] dx = {-1, 1, 0, 0, 0}; 
    static final int[] dy = {0, 0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (P-- > 0) {
            int target = 0;

            for (int i = 0; i < SIZE; i++) {
                String line = br.readLine();
                for (int j = 0; j < SIZE; j++) {
                    if (line.charAt(j) == '*') {
                        target |= (1 << (i * SIZE + j));
                    }
                }
            }

            Queue<int[]> queue = new LinkedList<>();
            boolean[] visited = new boolean[1 << 9];
            queue.offer(new int[]{0, 0}); // {보드 상태, 클릭 횟수}
            visited[0] = true;

            int result = -1;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int state = now[0], cnt = now[1];

                if (state == target) {
                    result = cnt;
                    break;
                }

                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        int nextState = state;

                        for (int d = 0; d < 5; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE) {
                                nextState ^= (1 << (nx * SIZE + ny)); // XOR 연산으로 상태 반전
                            }
                        }

                        if (!visited[nextState]) {
                            visited[nextState] = true;
                            queue.offer(new int[]{nextState, cnt + 1});
                        }
                    }
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }
}
