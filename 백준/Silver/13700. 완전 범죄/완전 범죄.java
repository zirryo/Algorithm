import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()) - 1;
        int D = Integer.parseInt(st.nextToken()) - 1;
        int F = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Set<Integer> policeStations = new HashSet<>();
        if (K > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                policeStations.add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.offer(new int[]{S, 0});
        visited[S] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentBuilding = current[0];
            int pressCount = current[1];

            if (currentBuilding == D) {
                System.out.println(pressCount);
                return;
            }

            if (currentBuilding + F < N && !visited[currentBuilding + F] && !policeStations.contains(currentBuilding + F)) {
                visited[currentBuilding + F] = true;
                queue.offer(new int[]{currentBuilding + F, pressCount + 1});
            }

            if (currentBuilding - B >= 0 && !visited[currentBuilding - B] && !policeStations.contains(currentBuilding - B)) {
                visited[currentBuilding - B] = true;
                queue.offer(new int[]{currentBuilding - B, pressCount + 1});
            }
        }

        System.out.println("BUG FOUND");
    }
}
