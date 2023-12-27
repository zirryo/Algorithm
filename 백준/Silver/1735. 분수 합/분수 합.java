import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int gcdB = getGCD(b1, b2);
        int B = b1 * b2 / gcdB;
        int A = a1 * (B / b1) + a2 * (B / b2);

        int gcd = getGCD(A, B);
        System.out.println(A/gcd + " " + B/gcd);
    }
    private static int getGCD(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        if (max % min == 0) return min;
        else return getGCD(max % min, min);
    }
}