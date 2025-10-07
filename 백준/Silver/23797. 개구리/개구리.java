import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int waitingK = 0;
        int maxFrogs = 0;

        for (char c : s.toCharArray()) {
            if (c == 'K') {
                waitingK++;
                maxFrogs = Math.max(maxFrogs, waitingK);
            } else if (c == 'P') {
                if (waitingK == 0) {
                    maxFrogs++;
                } else {
                    waitingK--;
                }
            }
        }

        System.out.println(maxFrogs);
    }
}
