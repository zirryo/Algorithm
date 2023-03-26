import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Session> pq = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.add(new Session(p, d));
        }

        boolean[] occupied = new boolean[10001];
        while(!pq.isEmpty()) {
            Session cur = pq.poll();
            for(int i = cur.due; i >= 1; i--) {
                if(occupied[i]) continue;
                occupied[i] = true;
                result += cur.pay;
                break;
            }
        }
        System.out.println(result);
    }
    private static class Session implements Comparable<Session> {
        int pay;
        int due;

        public Session(int pay, int due) {
            this.due = due;
            this.pay = pay;
        }

        @Override
        public int compareTo(Session session) {
            if(this.pay == session.pay) return session.due - this.due;
            return session.pay - this.pay;
        }
    }
}