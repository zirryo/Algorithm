import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] curve;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        curve = new int[4][1024];
        visited = new boolean[101][101];
        for(int i = 0; i < 4; i++) curve[i][0] = i; // 각각 i 방향으로 시작

        makeDragonCurve();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            drawDragonCurve(x, y, d, g);
        }
        System.out.println(countCube());
    }
    private static void makeDragonCurve() {
        // 다음 세대는 이전 세대 + (이전 세대 역순 + 1(90도 회전))
        for(int dir = 0; dir < 4; dir++) {
            for(int gen = 1; gen <= 10; gen++) {
                int e = (int)Math.pow(2, gen-1);
                for(int i=0, j=(int)Math.pow(2, gen)-1; i<e; i++, j--) {
                    curve[dir][j] = (curve[dir][i] + 1) % 4;
                }
            }
        }
    }
    private static void drawDragonCurve(int x, int y, int d, int g) {
        int curX = x;
        int curY = y;
        visited[curX][curY] = true;

        for(int i = 0; i < (int) Math.pow(2, g); i++) {
            switch (curve[d][i]) {
                case 0 : {
                    curX++;
                    break;
                }
                case 1 : {
                    curY--;
                    break;
                }
                case 2 : {
                    curX--;
                    break;
                }
                case 3 : {
                    curY++;
                    break;
                }
            }
            visited[curX][curY] = true;
        }
    }
    private static int countCube() {
        int cnt = 0;
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(!visited[i][j]) continue;
                if(visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]) cnt++;
            }
        }
        return cnt;
    }
}