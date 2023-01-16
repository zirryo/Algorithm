import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int cnt = 0;
    static final int INF = 125 * 125 * 10;
    static int[][] map;
    static int[][] cost;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            cnt++;

            map = new int[N][N];
            cost = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = INF;
                }
            }

            sb.append("Problem ").append(cnt).append(": ");
            dijkstra();
        }
        System.out.println(sb);
    }
    
    static void dijkstra() {
        cost[0][0] = map[0][0]; // 시작 위치는 반드시 지남

        PriorityQueue<Point> pq = new PriorityQueue<>(); // // 메모리 + 시간단축 + 최솟값을 구하기 위해 우선순위큐 사용
        pq.add(new Point(0, 0, cost[0][0]));

        while(!pq.isEmpty()) {
            Point point = pq.poll();

            for(int i=0; i<4; i++) {
                int nextY = point.y + dy[i];
                int nextX = point.x + dx[i];

                if(nextX>=0 && nextY>=0 && nextX<N && nextY<N) { // map 밖으로는 나갈 수 없음
                    if(cost[nextY][nextX] > map[nextY][nextX] + cost[point.y][point.x]) { // 경유를 통해 가중치를 줄일 수 있다면 비용 갱신
                        cost[nextY][nextX] = map[nextY][nextX] + cost[point.y][point.x];
                        pq.add(new Point(nextY, nextX, cost[nextY][nextX]));
                    }
                }
            }
        }
        sb.append(cost[N-1][N-1]).append("\n");
    }

    /* 다익스트라(dijkstra) 알고리즘
    - 그래프에서 여러 개의 노드가 있을 때, 특정한 한 정점(=노드)에서 출발하여 다른 모든 정점으로 가는 최단 경로를 구하는 알고리즘.
    - 가중치가 0보다 작은 값이 아닌 경우에 때 사용 가능
    - 그리디 알고리즘 기반 (항상 가장 작은 값 선택)
    - 우선순위 큐 활용
     */

}

class Point implements Comparable<Point> {
    int y;
    int x;
    int rupee;

    public Point(int y, int x, int rupee) {
        this.y = y;
        this.x = x;
        this.rupee = rupee;
    }

    public int compareTo(Point p) {
        return this.rupee - p.rupee;
    }
}