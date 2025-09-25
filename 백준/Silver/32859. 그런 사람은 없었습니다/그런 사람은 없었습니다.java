import java.io.*;
import java.util.*;

public class Main {
    static class Event {
        int id, type;
        Event(int id, int type) {
            this.id = id; this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());

        Event[] events = new Event[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            events[i] = new Event(id, t);
        }

        boolean[] hasForm = new boolean[N + 1];
        boolean[] hasDeposit = new boolean[N + 1];
        int[] formCountAfterDeposit = new int[N + 1]; 
        boolean[] forgotten = new boolean[N + 1]; 

        for (Event e : events) {
            if (e.type == 1) {
                hasDeposit[e.id] = true;
            } else {
                hasForm[e.id] = true;
                for (int i = 1; i <= N; i++) {
                    if (hasDeposit[i] && !hasForm[i] && !forgotten[i] && i != e.id) {
                        formCountAfterDeposit[i]++;
                        if (formCountAfterDeposit[i] >= S) {
                            forgotten[i] = true;
                        }
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (forgotten[i]) result.add(i);
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int id : result) {
                System.out.println(id);
            }
        }
    }
}
