import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        Meeting[] meetings = new Meeting[N];
        StringTokenizer st;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings);
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.add(meetings[0].e);

        for (int idx = 1; idx < N; idx++) {
            int cur = rooms.peek();

            if (cur <= meetings[idx].s) rooms.poll();
            rooms.add(meetings[idx].e);
            result = Math.max(result, rooms.size());
        }

        System.out.println(result);
    }
    private static class Meeting implements Comparable<Meeting> {
        int s;
        int e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Meeting m) {
            if (s == m.s) return e - m.e;
            return s - m.s;
        }
    }
}