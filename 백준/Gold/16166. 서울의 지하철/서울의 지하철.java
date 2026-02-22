import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<Long>[] lines = new HashSet[N];

        for (int i = 0; i < N; i++) {
            lines[i] = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                lines[i].add(Long.parseLong(st.nextToken()));
            }
        }

        long destination = Long.parseLong(br.readLine());

        if (destination == 0) {
            System.out.println(0);
            return;
        }

        boolean[][] transfer = new boolean[N][N];
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (transfer[i][j]) continue;

                for (Long station : lines[i]) {
                    if (lines[j].contains(station)) {
                        transfer[i][j] = transfer[j][i] = true;
                        break;
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[N];
        Arrays.fill(dist, -1);

        for (int i = 0; i < N; i++) {
            if (lines[i].contains(0L)) {
                queue.add(i);
                dist[i] = 0;
            }
        }

        int minTransfer = -1;
        while (!queue.isEmpty()) {
            int curLine = queue.poll();

            if (lines[curLine].contains(destination)) {
                minTransfer = dist[curLine];
                break;
            }

            for (int next = 0; next < N; next++) {
                if (transfer[curLine][next] && dist[next] == -1) {
                    dist[next] = dist[curLine] + 1;
                    queue.add(next);
                }
            }
        }

        System.out.println(minTransfer);
    }
}