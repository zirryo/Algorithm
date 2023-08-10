import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 1;
        ArrayList<Lesson> list = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Lesson(s, e));
        }

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0).end);

        for (int i = 1; i < N; i++) {
            int endTime = pq.peek();
            if (list.get(i).start < endTime) {
                pq.add(list.get(i).end);
            } else {
                pq.poll();
                pq.add(list.get(i).end);
            }
            result = Math.max(result, pq.size());
        }
        System.out.println(result);
    }

}
class Lesson implements Comparable<Lesson> {
    int start;
    int end;

    public Lesson(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lesson l) {
        if (start == l.start) return end - l.end;
        return start - l.start;
    }
}