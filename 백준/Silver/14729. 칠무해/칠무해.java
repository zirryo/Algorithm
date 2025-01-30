import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            double score = Double.parseDouble(br.readLine());
            maxHeap.add(score);
            if (maxHeap.size() > 7) {
                maxHeap.poll();
            }
        }

        List<Double> result = new ArrayList<>(maxHeap);
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (double num : result) {
            sb.append(String.format("%.3f\n", num));
        }
        System.out.print(sb);
    }
}
