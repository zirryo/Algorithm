import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[N + 1];
        int count = 0;
        int result = 0;

        Outer:
        for (int i = 2; i <= N; i++) {
            if (!check[i]) {
                for (int j = i; j <= N; j += i) {
                    if (!check[j]) {
                        check[j] = true;
                        count++;
                        if (count == K) {
                            result = j;
                            break Outer;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}