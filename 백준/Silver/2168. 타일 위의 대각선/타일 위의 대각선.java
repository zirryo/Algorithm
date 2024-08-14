import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 대각선이 격자를 지나갈 때, M개의 세로선과 N개의 가로선을 만남.
        // 최대공약수 지점에서 격자점을 동시에 지나가므로 중복되는 부분을 제외함.

        int gcd = getGCD(A, B);
        System.out.println(A + B - gcd);
    }

    public static int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }

}
