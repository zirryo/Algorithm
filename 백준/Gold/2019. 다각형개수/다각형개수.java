import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static Map<Point, Integer> indexMap = new HashMap<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static int idxCount = 0;

    static int getIndex(Point p) {
        if (!indexMap.containsKey(p)) {
            indexMap.put(p, idxCount++);
            graph.add(new ArrayList<>());
        }
        return indexMap.get(p);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            int a = getIndex(p1);
            int b = getIndex(p2);

            if (a == b) continue;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[idxCount];
        int polygonCount = 0;

        for (int start = 0; start < idxCount; start++) {
            if (visited[start]) continue;

            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            visited[start] = true;

            boolean isCycle = true;
            int nodeCount = 0;
            int edgeCount = 0;

            while (!q.isEmpty()) {
                int cur = q.poll();
                nodeCount++;

                int deg = graph.get(cur).size();
                edgeCount += deg;

                if (deg != 2) isCycle = false;

                for (int nxt : graph.get(cur)) {
                    if (!visited[nxt]) {
                        visited[nxt] = true;
                        q.offer(nxt);
                    }
                }
            }

            edgeCount /= 2;
            
            if (isCycle && edgeCount == nodeCount) {
                polygonCount++;
            }
        }

        System.out.println(polygonCount);
    }
}
