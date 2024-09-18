import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int diff = 0;
        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
        int[] cnt = new int[4];
        char[] type = {'A', 'C', 'G', 'T'};

        for (int i = 0; i < M; i++) {
            Arrays.fill(cnt, 0);
            for (int j = 0; j < N; j++) {
                for (int k  = 0; k < 4; k++) {
                    if (input[j].charAt(i) == type[k]) {
                        cnt[k]++;
                        break;
                    }
                }
            }

            int maxCnt = 0;
            char maxType = ' ';
            for (int l = 0; l < 4; l++) {
                if (cnt[l] > maxCnt) {
                    maxCnt = cnt[l];
                    maxType = type[l];
                }
            }
            sb.append(maxType);
            diff += (N - maxCnt);
        }
        System.out.println(sb + "\n" + diff);
    }
}
