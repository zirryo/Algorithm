import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        long[] money = new long[y + 1];
        money[0] = n;

        for (int i = 1; i <= y; i++) {
            money[i] = (long) (money[i-1] * 1.05);

            if (i >= 3) {
                money[i] = (long) Math.max(money[i-3] * 1.2, money[i]);
            }

            if (i >= 5) {
                money[i] = (long) Math.max(money[i-5] * 1.35, money[i]);
            }
        }

        System.out.println(money[y]);
    }
}