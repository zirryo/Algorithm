import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayList<Ball>[][] map;
    static List<Ball> ballList;
    public static void main(String[] args) throws IOException {
        init();
        while (K-- > 0) {
            moveBall();
            mergeAndSplit();
            setBallList();
        }
        System.out.println(getTotalMass());
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        ballList = new LinkedList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            ballList.add(new Ball(r-1, c-1, m, s, d));
        }
    }
    private static void moveBall() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        for(Ball cur : ballList) {
            cur.r += dr[cur.dir] * (cur.velocity % N);
            cur.c += dc[cur.dir] * (cur.velocity % N);

            if(cur.r >= N) cur.r %= N;
            else if (cur.r < 0) cur.r = N + cur.r;
            if(cur.c >= N) cur.c %= N;
            else if (cur.c < 0) cur.c = N + cur.c;

            map[cur.r][cur.c].add(cur);
        }

    }
    private static void mergeAndSplit() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j].size() < 2) continue;
                int sumMass = 0, sumVel = 0, cnt = map[i][j].size();
                boolean[] isOdd = new boolean[map[i][j].size()];
                for(int k=0; k < map[i][j].size(); k++) {
                     sumMass += map[i][j].get(k).mass;
                     sumVel += map[i][j].get(k).velocity;
                     isOdd[k] = map[i][j].get(k).dir % 2 == 1;
                }
                map[i][j] = new ArrayList<>();
                sumMass /= 5;
                if(sumMass <= 0) continue;
                sumVel /= cnt;
                boolean flag = true;
                for(int k=1; k < isOdd.length; k++) {
                    if(isOdd[0] != isOdd[k]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int k=0; k<4; k++) {
                        map[i][j].add(new Ball(i, j, sumMass, sumVel, 2*k));
                    }
                } else {
                    for(int k=0; k<4; k++) {
                        map[i][j].add(new Ball(i, j, sumMass, sumVel, 2*k+1));
                    }
                }
            }
        }
    }
    private static void setBallList() {
        ballList = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j].size() == 0) continue;
                ballList.addAll(map[i][j]);
            }
        }
    }
    private static int getTotalMass() {
        int result = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j].size() == 0) continue;
                for(Ball ball : map[i][j]) result += ball.mass;
            }
        }
        return result;
    }
    private static class Ball {
        int r;
        int c;
        int mass;

        int velocity;
        int dir;

        public Ball(int r, int c, int mass, int velocity, int dir) {
            this.r = r;
            this.c = c;
            this.mass = mass;
            this.dir = dir;
            this.velocity = velocity;
        }
    }
}