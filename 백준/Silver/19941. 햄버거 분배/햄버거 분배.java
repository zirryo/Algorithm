import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;

        Queue<Integer> person = new LinkedList<>();
        Queue<Integer> hamburger = new LinkedList<>();

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == 'H') hamburger.add(i);
            else person.add(i);

            while (!hamburger.isEmpty() && !person.isEmpty()) {
                int h = hamburger.peek();
                int p = person.peek();
                if (Math.abs(h - p) <= K) {
                    hamburger.poll();
                    person.poll();
                    result++;
                } else if (h < p) {
                    hamburger.poll();
                } else {
                    person.poll();
                }
            }
        }
        System.out.println(result);
    }
}