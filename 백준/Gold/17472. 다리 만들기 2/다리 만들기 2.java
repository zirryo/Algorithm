import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, landNum, result;
    static int[] parent;
    static int[][] map; // 0 - 바다, 1 - 땅
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        init();
        bfs(); // 각각의 섬을 구분하여 섬 고유번호 마킹
        makeBridge(); // 길이가 2이상이 되도록 다리 놓기
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

    }
    private static void bfs() {
        Queue<Pos> q;
        landNum = 2;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    q = new LinkedList<>();
                    q.add(new Pos(i, j));
                    visited[i][j] = true;
                    map[i][j] = landNum;
                    while(!q.isEmpty()) {
                        Pos cur = q.poll();
                        for(int k=0; k<4; k++) {
                            int nr = cur.r + dr[k];
                            int nc = cur.c + dc[k];
                            if(inRange(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
                                q.add(new Pos(nr, nc));
                                visited[nr][nc] = true;
                                map[nr][nc] = landNum;
                            }
                        }
                    }
                    landNum++;
                }
            }
        }
    }
    private static void makeBridge() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] < 2) continue; // 섬 고유번호는 2부터 시작
                int curLand = map[i][j]; // 현재 위치의 섬 번호
                for(int k=0; k<4; k++) {
                    int nr = dr[k] + i;
                    int nc = dc[k] + j;
                    int dist = 0; // 다리 길이 저장
                    while(true) {
                        if(!inRange(nr, nc)) break;
                        int next = map[nr][nc];

                        if(next == curLand) break; // 이동 위치가 같은 섬일 경우
                        if(next == 0) { // 이동 위치가 바다인 경우 다리 길이 늘림
                            dist++;
                            nr += dr[k]; // 같은 방향으로 이동
                            nc += dc[k]; // 같은 방향으로 이동
                            continue;
                        }
                        if(dist < 2) break; // 다리 길이는 2이상이어야 함
                        pq.add(new Edge(curLand, next, dist));
                        break;
                    }
                }
            }
        }

        parent = new int[landNum];
        for(int i=2; i<landNum; i++) parent[i] = i;

        int bridgeCnt = landNum - 3; // MST 를 만들기 위해 간선 수는 정점 수 - 1
        while(bridgeCnt > 0) {
            if(pq.isEmpty()) {
                result = -1;
                break;
            }
            Edge cur = pq.poll();
            if(union(cur.s, cur.e)) {
                result += cur.dist;
                bridgeCnt--;
            }
        }
    }
    private static boolean inRange(int r, int c) {
        return r<N && r>=0 && c<M && c>=0;
    }
    private static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
            return true;
        }
        return false;
    }
    private static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    private static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int dist;

        public Edge(int s, int e, int dist) {
            this.s = s;
            this.e = e;
            this.dist = dist;
        }
        @Override
        public int compareTo(Edge edge) {
            return this.dist - edge.dist;
        }
    }
}