import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] piece = new int[4];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.charAt(0) == '3') piece[3]++;
            else {
                if (s.charAt(2) == '2') piece[2]++;
                else piece[1]++;
            }
        }

        int result = piece[3];
        piece[1] -= piece[3];

        result += (piece[2] / 2);

        if (piece[2] % 2 != 0) {
            result++;
            if (piece[1] > 0) {
                piece[1] -= 2;
            }
        }

        if (piece[1] > 0) {
            piece[1] += 3;
            result += (piece[1] / 4);
        }

        System.out.println(result);
    }
}