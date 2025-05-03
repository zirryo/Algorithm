import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static int[] rumorTime;
    static int[] neededToBelieve;
    static int[] countBelieve;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        rumorTime = new int[N + 1]; 
        countBelieve = new int[N + 1];
        neededToBelieve = new int[N + 1];
        Arrays.fill(rumorTime, -1);

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (true) {
                int neighbor = Integer.parseInt(st.nextToken());
                if (neighbor == 0) break;
                graph[i].add(neighbor);
            }
            neededToBelieve[i] = (graph[i].size() + 1) / 2;
        }

        int M = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int first = Integer.parseInt(st.nextToken());
            rumorTime[first] = 0;
            queue.offer(first);
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int time = rumorTime[curr];

            for (int neighbor : graph[curr]) {
                if (rumorTime[neighbor] != -1) continue;
                countBelieve[neighbor]++;

                if (countBelieve[neighbor] >= neededToBelieve[neighbor]) {
                    rumorTime[neighbor] = time + 1;
                    queue.offer(neighbor);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(rumorTime[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
