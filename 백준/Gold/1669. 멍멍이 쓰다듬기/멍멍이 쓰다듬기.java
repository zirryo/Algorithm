import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int target = b - a;

        if (target <= 3) System.out.println(target);
        else {
            int x = getSquare(target);
            if (x * x == target) {
                System.out.println(2 * x - 1);
            } else {
                System.out.println(getMinDay(target, x));
            }
        }
    }
    private static int getSquare (int target) { // 타겟 이하의 가장 큰 제곱 수 찾기
        double x = Math.sqrt(target);
        return (int) Math.floor(x);
    }
    private static int getMinDay (int target, int sqrt) {
        int cnt = sqrt * 2 - 1; // "타겟 이하의 가장 큰 제곱 수"의 최소 일수
        int diff = target - sqrt * sqrt;

        while (diff > 0) {
            cnt++;
            if (diff > sqrt) {
                diff -= sqrt;
            } else {
                diff = 0;
            }
        }
        return cnt;
    }
}