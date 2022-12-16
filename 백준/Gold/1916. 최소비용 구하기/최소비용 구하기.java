import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int INF = 1000 * 100000;
    static int start, end;
    static ArrayList<Point>[] list;
    static int[] dist;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        dist = new int[N+1];
        isVisited = new boolean[N+1];

        Arrays.fill(dist, INF);

        for(int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        while(M-->0) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Point(e, w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();
        System.out.println(dist[end]);

    }

    static void dijkstra() {

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Point p = pq.poll();

            if(!isVisited[p.e]) {
                isVisited[p.e] = true;
                for(Point po : list[p.e]) {
                    if(dist[p.e] + po.w < dist[po.e]) {
                        dist[po.e] = dist[p.e] + po.w;
                        pq.add(new Point(po.e, dist[po.e]));
                    }
                }
            }
        }
    }
    
    static class Point implements Comparable<Point> {
        int e;
        int w;

        public Point(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Point p) {
            return  this.w - p.w;
        }
    }

}