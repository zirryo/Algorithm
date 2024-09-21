import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int D1 = Integer.parseInt(inputs[0]);
        int D2 = Integer.parseInt(inputs[1]);

        int result = 0;

        boolean[][] visited = new boolean[D2+1][D2+1];

        for (int dist = D1; dist <= D2; dist++) {
            for (int j=1; j<=dist; j++) {
                int gcd = getGCD(dist, j);
                int a = (int) j / gcd;
                int b = (int) dist / gcd;

                if (!visited[a][b]) {
                    visited[a][b] = true;
                    result++;
                }
            }
        }

        System.out.println(result);

    }

    public static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
