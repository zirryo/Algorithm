import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static List<Position> chicken;
    static List<Position> house;
    static List<Position> pick;
    static int result = Integer.MAX_VALUE;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집 수 (max)
        map = new int[N][N];

        chicken = new ArrayList<>();
        house = new ArrayList<>();
        pick = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) house.add(new Position(i, j)); // 집의 좌표
                if(map[i][j] == 2) chicken.add(new Position(i, j)); // 치킨집의 좌표
            }
        }
        isVisited = new boolean[chicken.size()]; // 치킨집 방문여부 체크

        backTracking(0, 0);
        System.out.println(result);
    }
    
    static void backTracking(int idx, int depth) {
        if(depth == M) {
            int chickenDistance = 0;
            for(Position h : house) {
                int min = Integer.MAX_VALUE;
                for(Position p : pick) {
                    int d = Math.abs(h.y - p.y) + Math.abs(h.x - p.x);
                    min = Math.min(min, d); // 집마다 치킨거리를 구함
                }
                chickenDistance += min;
            }
            result = Math.min(result, chickenDistance); // 선택한 치킨집 조합마다 전체 치킨 거리 최솟값 갱신
            return;
        }
        // M개의 치킨집을 선택
        for(int i=idx; i<chicken.size(); i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                pick.add(chicken.get(i));
                backTracking(i+1, depth+1);

                pick.remove(chicken.get(i));
                isVisited[i] = false;
            }
        }
    }
    
    public static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
