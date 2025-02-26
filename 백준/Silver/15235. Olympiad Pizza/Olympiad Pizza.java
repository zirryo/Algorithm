import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] pizza = new int[N];
        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            pizza[i] = Integer.parseInt(st.nextToken());
            q.add(i);
        }

        int time = 1;
        while (!q.isEmpty()) {
            int idx = q.pollFirst();
            
            if (--pizza[idx] > 0) {
                q.addLast(idx);
            } else {
                result[idx] = time;
            }
            
            time++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}