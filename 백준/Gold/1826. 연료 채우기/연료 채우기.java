import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Station> stations = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            stations.add(new Station(a, b));
        }

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        Collections.sort(stations);
        int idx = 0;
        int pos = P; // 초기 연료 == 갈 수 있는 거리
        int cnt = 0;
        while (pos < L) {
            while (idx < N && stations.get(idx).dist <= pos) {
                pq.add(stations.get(idx).capacity);
                idx++;
            }

            if (pq.isEmpty()) {
                cnt = -1;
                break;
            }

            pos += pq.poll();
            cnt++;
        }
        System.out.println(cnt);
    }
}
class Station implements Comparable<Station> {
    int dist;
    int capacity;

    public Station(int dist, int capacity) {
        this.dist = dist;
        this.capacity = capacity;
    }

    @Override
    public int compareTo(Station station) {
        if (station.dist == this.dist) return station.capacity - this.capacity;
        else return this.dist - station.dist;
    }
}