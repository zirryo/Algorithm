import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st1.nextToken());

            if (a == 0) dq.addLast(b);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int X = Integer.parseInt(st.nextToken());
            dq.addFirst(X);
            sb.append(dq.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}