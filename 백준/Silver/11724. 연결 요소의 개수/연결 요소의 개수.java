import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] isVisited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N+1];
        map = new int[N+1][N+1];

        while(M-->0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start][end] = map[end][start] = 1;
        }

        int cnt = 0;
        for(int x=1; x<=N; x++) {
            if(!isVisited[x]) {
                cnt++;
                bfs(x);
            }
        }
        System.out.println(cnt);
    }
    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        isVisited[x] = true;
        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int i=1; i<=N; i++) {
                if(map[temp][i]==1 && !isVisited[i]) {
                    q.offer(i);
                    isVisited[i] = true;
                }
            }
        }
    }
}