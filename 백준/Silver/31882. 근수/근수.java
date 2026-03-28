import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        long totalScore = 0;
        long L = 0;

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == '2') {
                L++;
            } else {
                if (L > 0) {
                    totalScore += calculateScore(L);
                    L = 0;
                }
            }
        }

        if (L > 0) {
            totalScore += calculateScore(L);
        }

        System.out.println(totalScore);
    }

    private static long calculateScore(long l) {
        return l * (l + 1) * (l + 2) / 6;
    }
}