import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String num = br.readLine();
        Deque<Character> q = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (K > 0 && !q.isEmpty() && q.getLast() < c) {
                q.removeLast();
                K--;
            }
            q.addLast(c);
        }
        while (q.size() > K) {
            sb.append(q.removeFirst());
        }
        System.out.println(sb);
    }
}