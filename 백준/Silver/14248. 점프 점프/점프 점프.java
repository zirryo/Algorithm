import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int start = Integer.parseInt(br.readLine()) - 1;
        q.add(start);
        visited[start] = true;

        int result = 0;

        while (!q.isEmpty()) {
            result++;
            int cur = q.poll();
            int left = cur - arr[cur];
            int right = cur + arr[cur];

            if (left >= 0 && !visited[left]) {
                q.add(left);
                visited[left] = true;
            }

            if (right < n && !visited[right]) {
                q.add(right);
                visited[right] = true;
            }
        }

        System.out.println(result);
    }
}
