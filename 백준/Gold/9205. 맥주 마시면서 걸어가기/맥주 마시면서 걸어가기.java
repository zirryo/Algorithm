import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Pos home;
    static Pos festival;
    static Pos[] stores;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            home = new Pos(new StringTokenizer(br.readLine()));
            stores = new Pos[N];
            graph = new ArrayList[N];
            for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
            for(int i=0; i<N; i++) stores[i] = new Pos(new StringTokenizer(br.readLine()));
            festival = new Pos(new StringTokenizer(br.readLine()));
            makeGraph();

            if(bfs()) sb.append("happy\n");
            else sb.append("sad\n");
        }
        System.out.println(sb);
    }
    private static void makeGraph() {
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(canMove(stores[i], stores[j])) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
    }
    private static boolean bfs() {
        if(canMove(home, festival)) return true;
        boolean result = false;
        Queue<Integer> q = new LinkedList();
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++) {
            if(canMove(home, stores[i])) {
                visited[i] = true;
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();

            if(canMove(stores[cur], festival)) {
                result = true;
                break;
            }
            for(int i : graph[cur]) {
                if(visited[i]) continue;
                visited[i] = true;
                q.add(i);
            }
        }
        return result;
    }
    private static boolean canMove(Pos a, Pos b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c) <= 1000;
    }
    private static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public Pos(StringTokenizer st) {
            this.r = Integer.parseInt(st.nextToken());
            this.c = Integer.parseInt(st.nextToken());
        }
    }
}