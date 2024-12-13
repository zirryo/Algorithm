import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] compound = new int[3][3];
        char[] atom = {'C', 'H', 'O'};
        int idx = 0;
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            if (c == '+' || c == '=') {
                idx++;
            } else {
                for (int j = 0; j < 3; j++) {
                    if (c != atom[j]) continue;
                    if (i + 1 < input.length && Character.isDigit(input[i+1])) {
                        compound[idx][j] += Integer.parseInt(Character.toString(input[i+1]));
                    } else {
                        compound[idx][j]++;
                    }
                }
            }
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k <= 10; k++) {
                    if (compound[0][0] * i + compound[1][0] * j == compound[2][0] * k &&
                            compound[0][1] * i + compound[1][1] * j == compound[2][1] * k &&
                        compound[0][2] * i + compound[1][2] * j == compound[2][2] * k) {
                        System.out.printf("%d %d %d", i, j, k);
                        return;
                    }
                }
            }
        }

    }
}
