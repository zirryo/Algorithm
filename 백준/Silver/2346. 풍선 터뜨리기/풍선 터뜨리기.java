import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            dq.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }
        int preMove = 0;
        Balloon cur;
        while (dq.size() >= 2) {
            if (preMove >= 0) cur = dq.pollFirst();
            else cur = dq.pollLast();
            sb.append(cur.idx).append(" ");

            for (int i = 1; i < Math.abs(cur.move); i++) {
                if (cur.move > 0) dq.addLast(dq.pollFirst());
                else dq.addFirst(dq.pollLast());
            }

            preMove = cur.move;
        }
        sb.append(dq.pollFirst().idx);
        System.out.println(sb);
    }
}
class Balloon {
    int idx;
    int move;

    public Balloon(int idx, int move) {
        this.idx = idx;
        this.move = move;
    }
}