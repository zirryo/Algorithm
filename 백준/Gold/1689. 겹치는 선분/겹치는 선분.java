import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 1;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Line> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new Line(l, r));
        }

        Collections.sort(list);

        for (Line cur : list) {
            while (!pq.isEmpty() && pq.peek() <= cur.l) {
                pq.poll();
            }
            pq.add(cur.r);
            result = Math.max(result, pq.size());
        }
        System.out.println(result);
    }
}
class Line implements Comparable<Line> {
    int l;
    int r;

    public Line(int l, int r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Line line) {
        if (this.l == line.l) return this.r - line.r;
        return this.l - line.l;
    }
}