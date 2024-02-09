import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            if (N >= 33) {
                sb.append("0\n");
                continue;
            }

            String[] mbti = new String[N];
            for (int i=0; i<N; i++) {
                mbti[i] = st.nextToken();
            }

            int min = 9;

            Outer:
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        int diff = 0;
                        for (int l = 0; l < 4; l++) {
                            diff += mbti[i].charAt(l) != mbti[j].charAt(l) ? 1 : 0;
                            diff += mbti[j].charAt(l) != mbti[k].charAt(l) ? 1 : 0;
                            diff += mbti[k].charAt(l) != mbti[i].charAt(l) ? 1 : 0;
                        }

                        min = Math.min(min, diff);
                        if (min == 0) break Outer;
                    }
                }
            }

            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
}