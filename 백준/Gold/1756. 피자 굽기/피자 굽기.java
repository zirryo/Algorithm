import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] diameter = new int[D+1];
        int pass = 1_000_000_000;
        for (int i = 1; i <= D; i++) {
            pass = Math.min(pass, Integer.parseInt(st.nextToken()));
            diameter[i] = pass;
        }

        st = new StringTokenizer(br.readLine());
        int pizza;
        int depth = D;
        for (int i = 0; i < N; i++) {
            pizza = Integer.parseInt(st.nextToken());
            while (depth >= 0 && pizza > diameter[depth--]);
        }
        System.out.println(depth + 1);
    }
}