import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long atk = Long.parseLong(st.nextToken());
        long curHP = 0;
        long maxHP = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (t == 1) {
                curHP += a * ((h / atk) - (h % atk == 0 ? 1 : 0));
                maxHP = Math.max(curHP, maxHP);
            } else {
                atk += a;
                curHP = Math.max(curHP - h, 0);
            }
        }

        System.out.println(++maxHP);
    }
}
