import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐를 이용하여 최소힙 구현

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) sb.append(pq.size() == 0 ? 0 : pq.poll()).append("\n");
            else pq.add(x);
        }
        System.out.println(sb);
    }
}