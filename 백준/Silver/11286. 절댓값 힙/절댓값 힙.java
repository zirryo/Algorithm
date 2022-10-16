import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)) return  Math.abs(o1) - Math.abs(o2);
                else if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
                else return -1;
            }
        });

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            int k = Integer.parseInt(br.readLine());

            if(k == 0) sb.append(pq.size() == 0 ? 0 : pq.poll()).append("\n");
            else pq.add(k);
        }
        System.out.println(sb);
    }
}