import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(countDuck(input));
    }
    private static int countDuck(String s) {
        int[] cnt = new int[5]; // q, u, a, c, k
        int duck = 0;
        int activeDuck = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'q':
                    cnt[0]++;
                    activeDuck++;
                    break;
                case 'u':
                    if (cnt[0] <= cnt[1]) return -1;
                    cnt[1]++;
                    break;
                case 'a':
                    if (cnt[1] <= cnt[2]) return -1;
                    cnt[2]++;
                    break;
                case 'c':
                    if (cnt[2] <= cnt[3]) return -1;
                    cnt[3]++;
                    break;
                case 'k':
                    if (cnt[3] <= cnt[4]) return -1;
                    cnt[4]++;
                    activeDuck--;
                    break;
                default: return -1;
            }

            if (activeDuck > duck) {
                duck = activeDuck;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (cnt[i] != cnt[i+1]) return -1;
        }

        return duck;
    }
}