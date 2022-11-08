import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0; i<N; i++) {
            int k = Integer.parseInt(br.readLine());
            pq.add(k);
        }

        while(pq.size() > 1) { // 두 개의 값을 더해야 하므로 사이즈가 1이 넘어야 함
            int a = pq.poll();
            int b = pq.poll();

            result += a+b;
            pq.add(a+b);
        }
        System.out.println(result);
    }
}