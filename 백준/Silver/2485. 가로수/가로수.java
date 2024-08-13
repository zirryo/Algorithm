import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] positions = new int[N];

        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(br.readLine());
        }

        int[] dist = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            dist[i] = positions[i + 1] - positions[i];
        }

        int gcdValue = dist[0];
        for (int i = 1; i < dist.length; i++) {
            gcdValue = gcd(gcdValue, dist[i]);
        }

        int result = 0;
        for (int i = 0; i < dist.length; i++) {
            result += (dist[i] / gcdValue - 1);
        }

        System.out.println(result);
    }
}
