import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순으로 최대힙 구현
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            int k = Integer.parseInt(br.readLine());

            if(k == 0) sb.append(pq.size() == 0 ? 0 : pq.poll()).append("\n");
            else pq.add(k);
        }
        System.out.println(sb);
    }
}