import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            for (int i=1; i<K; i++) {
                q.add(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }

        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);
    }
}