import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[N+1];
        StringTokenizer st;
        ArrayList<Integer>[] friends = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        for (int fr : friends[1]) {
            check[fr] = true;
            for (int frfr : friends[fr]) {
                if (!check[frfr]) check[frfr] = true;
            }
        }

        int result = 0;
        for (int i=2; i<=N; i++) {
            if (check[i]) result++;
        }
        System.out.println(result);
    }
}