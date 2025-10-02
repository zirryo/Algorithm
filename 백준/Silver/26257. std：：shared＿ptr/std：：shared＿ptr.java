import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] pointer = new int[M + 1];
        int[] refCount = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            int e = Integer.parseInt(br.readLine());
            pointer[i] = e;
            if (e != 0) {
                refCount[e]++;
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("assign")) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                int oldObj = pointer[x];
                if (oldObj != 0) refCount[oldObj]--;

                pointer[x] = pointer[y];
                int newObj = pointer[x];
                if (newObj != 0) refCount[newObj]++;

            } else if (op.equals("swap")) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                int tmp = pointer[x];
                pointer[x] = pointer[y];
                pointer[y] = tmp;


            } else if (op.equals("reset")) {
                int x = Integer.parseInt(st.nextToken());
                int oldObj = pointer[x];
                if (oldObj != 0) {
                    refCount[oldObj]--;
                    pointer[x] = 0;
                }
            }
        }

        List<Integer> alive = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (refCount[i] > 0) alive.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(alive.size()).append("\n");
        for (int obj : alive) {
            sb.append(obj).append("\n");
        }
        System.out.print(sb);
    }
}
