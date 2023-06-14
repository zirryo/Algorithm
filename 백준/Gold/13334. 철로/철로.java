import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result = 0;
    static ArrayList<Road> roadList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        roadList = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a > b) roadList.add(new Road(b, a));
            else roadList.add(new Road(a, b));
        }
        M = Integer.parseInt(br.readLine());

        Collections.sort(roadList);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Road road : roadList) {
            if (road.e - road.s > M) continue;
            pq.add(road.s);
            while (!pq.isEmpty()) {
                int front = pq.peek();
                if (road.e - front <= M) break;
                pq.poll();
            }
            result = Math.max(result, pq.size());
        }
        System.out.println(result);

    }
    private static class Road implements Comparable<Road> {
        int s;
        int e;

        public Road(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Road v) {
            if(this.e == v.e) return this.s - v.s;
            return this.e - v.e;
        }
    }
}