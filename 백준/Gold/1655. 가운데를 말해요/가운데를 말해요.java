import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            int K = Integer.parseInt(br.readLine());

            if(maxHeap.size() == minHeap.size()) {
                maxHeap.add(K);

                if(!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            } else {
                minHeap.add(K);

                if(minHeap.peek() < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}