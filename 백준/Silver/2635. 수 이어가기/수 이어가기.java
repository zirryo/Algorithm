import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> maxSequence = new ArrayList<>();
        int maxLength = 0;
        
        for (int x = 1; x <= N; x++) {
            List<Integer> sequence = new ArrayList<>();
            sequence.add(N);
            sequence.add(x);

            int first = N, second = x;
            while (true) {
                int next = first - second;
                if (next < 0) break;
                sequence.add(next);
                first = second;
                second = next;
            }
            
            if (sequence.size() > maxLength) {
                maxLength = sequence.size();
                maxSequence = sequence;
            }
        }
        
        System.out.println(maxLength);
        for (int num : maxSequence) {
            System.out.print(num + " ");
        }
    }
}
