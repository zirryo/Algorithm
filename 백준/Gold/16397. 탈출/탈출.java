import java.io.*;
import java.util.*;

public class Main {
    static int N, T, G;
    static boolean[] visited = new boolean[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        int result = bfs();
        System.out.println(result == -1 ? "ANG" : result);
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0], cnt = cur[1];

            if (num == G) return cnt;
            if (cnt >= T) continue;

            if (num + 1 < 100000 && !visited[num + 1]) {
                visited[num + 1] = true;
                queue.add(new int[]{num + 1, cnt + 1});
            }

            if (num * 2 < 100000) {
                int next = num * 2;
                next = reduceLeftDigit(next);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, cnt + 1});
                }
            }
        }
        return -1;
    }

    static int reduceLeftDigit(int num) {
        if (num == 0) return 0;
        char[] chars = String.valueOf(num).toCharArray();
        chars[0] -= 1;
        return Integer.parseInt(new String(chars));
    }
}
