import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        int maxSize = 0;
        int lastNum = 100_000;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int student = Integer.parseInt(st.nextToken());
                queue.addLast(student);

                int size = queue.size();

                if (size > maxSize) {
                    maxSize = size;
                    lastNum = student;
                } else if (size == maxSize) {
                    lastNum = Math.min(lastNum, student);
                }

            } else if (type == 2) {
                queue.pollFirst();
            }
        }

        System.out.println(maxSize + " " + lastNum);
    }
}
