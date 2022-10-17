import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static int[][] result;
    public static boolean[][] isVisited;
    public static int N;
    public static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = new int[N][M];
        isVisited = new boolean[N][M];

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) {
                    q.offer(i);
                    q.offer(j);
                    isVisited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int y1 = q.poll();
            int x1 = q.poll();

            for(int i=0; i<4; i++) {
                int y = y1 + dy[i];
                int x = x1 + dx[i];

                if(!inRange(y, x)) continue;
                if(isVisited[y][x]) continue;
                if(map[y][x]==0) continue;

                isVisited[y][x] = true;
                result[y][x] = result[y1][x1] + 1;
                q.offer(y);
                q.offer(x);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0 && !isVisited[i][j]) sb.append(-1).append(" ");
                else sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean inRange(int y, int x) {
        if(x>=0 && x<M && y>=0 && y<N) return true;
        return false;
    }
}