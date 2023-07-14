import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long result = 0L;
        int max = 0;
        int min = 51;
        int min2 = 102;
        int min3 = 153;
        int[] dice = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, dice[i]);
            result += dice[i];
        }

        if (N == 1) {
            System.out.println(result - max);
        } else {
            for (int i = 0; i < 6; i++) {
                min = Math.min(min, dice[i]);

                for (int j = i + 1; j < 6; j++) {
                    if (i + j == 5) continue; // 두면이 이웃하지 않는 경우
                    min2 = Math.min(min2, dice[i] + dice[j]);

                    for (int k = j + 1; k < 6; k++) {
                        if (i + k == 5 || j + k == 5) continue; // 세면이 이웃하지 않는 경우
                        min3 = Math.min(min3, dice[i] + dice[j] + dice[k]);
                    }
                }
            }
            result = 0;
            if (N >= 3) result += min * (5 * N * N - 16 * N + 12);
            result += min2 * (8 * N - 12);
            result += min3 * 4;
            System.out.println(result);
        }
    }
}