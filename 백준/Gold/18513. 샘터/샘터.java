import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 1};
    static Set<Long> visited = new HashSet<>();

    static class Position {
        long pos;
        long dist;

        Position(long pos, long dist) {
            this.pos = pos;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Position> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            long pos = Long.parseLong(st.nextToken());
            visited.add(pos);
            queue.offer(new Position(pos, 0));
        }

        long result = 0;
        int count = 0;

        while (!queue.isEmpty() && count < K) {
            Position now = queue.poll();

            for (int d : dx) {
                long next = now.pos + d;
                if (visited.contains(next)) continue;

                visited.add(next);
                result += now.dist + 1;
                queue.offer(new Position(next, now.dist + 1));
                count++;

                if (count == K) break;
            }
        }

        System.out.println(result);
    }
}
