import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cheap6 = 1001;
        int cheap1 = 1001;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int six = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            cheap6 = Math.min(cheap6, six);
            cheap1 = Math.min(cheap1, one);
        }

        int money = 0;

        if (cheap6 < cheap1 * 6) { // 패키지가 이득인 경우
            money += (cheap6 * (N / 6));
            int remain = N % 6;
            if (remain * cheap1 > cheap6) {
                money += cheap6;
            } else {
                money += (remain * cheap1);
            }
        } else { // 낱개 구매가 이득인 경우
            money += (N * cheap1);
        }
        System.out.println(money);
    }
}