import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        String encrypted = br.readLine();
        int len = encrypted.length();
        int rows = len / K;

        char[][] table = new char[rows][K];
        int idx = 0;

        for (int r = 0; r < rows; r++) {
            if (r % 2 == 0) {
                for (int c = 0; c < K; c++) {
                    table[r][c] = encrypted.charAt(idx++);
                }
            } else {
                for (int c = K - 1; c >= 0; c--) {
                    table[r][c] = encrypted.charAt(idx++);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < K; c++) {
            for (int r = 0; r < rows; r++) {
                sb.append(table[r][c]);
            }
        }

        System.out.println(sb.toString());
    }
}
