import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int result1 = 0;
    static int result2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        isVisited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j]) {
                    dfs(i, j);
                    result1++; // 새로운 구역을 찾을 때 마다 + 1
                }
            }
        }

        isVisited = new boolean[N][N]; // 초기화

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 'G') map[i][j] = 'R'; // 색약 그림 만들기
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j]) {
                    dfs(i, j);
                    result2++; // 새로운 구역을 찾을 때 마다 + 1
                }
            }
        }
        System.out.println(result1 + " " + result2);
    }
    private static boolean inRange(int y, int x) {
        return y<N && y>=0 && x<N && x>=0;
    }

    private static void dfs(int y, int x) {
        isVisited[y][x] = true;
        char temp = map[y][x];

        for(int i=0; i<4; i++) {
            int y1 = y + dy[i];
            int x1 = x + dx[i];

            if(inRange(y1, x1) && temp == map[y1][x1] && !isVisited[y1][x1]) {
                dfs(y1, x1);
            }
        }
    }

}