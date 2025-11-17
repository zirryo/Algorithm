import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        class Info {
            int W, D, P;
            Info(int W, int D, int P) {
                this.W = W; this.D = D; this.P = P;
            }
        }

        Map<String, Info> infoMap = new HashMap<>();
        List<String> names = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            int W = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            infoMap.put(S, new Info(W, D, P));
            names.add(S);
        }

        Map<String, Integer> money = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            int M = Integer.parseInt(st.nextToken());
            money.put(S, M);
        }

        boolean[] can = new boolean[70];

        for (String name : names) {
            Info info = infoMap.get(name);
            int M = money.get(name);
            if (M >= info.P) { 
                int day = (info.W - 1) * 7 + info.D;
                can[day] = true;
            }
        }

        int maxStreak = 0;
        int cur = 0;

        for (int i = 0; i < 70; i++) {
            if (can[i]) {
                cur++;
                maxStreak = Math.max(maxStreak, cur);
            } else {
                cur = 0;
            }
        }

        System.out.println(maxStreak);
    }
}
