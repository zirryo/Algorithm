import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        long totalCost = 0;

        while (pq.size() > 1) {
            long x = pq.poll();
            long y = pq.poll(); 

            long cost = x * y; 
            totalCost += cost; 

            pq.add(x + y); 
        }

        System.out.println(totalCost);
    }
}
