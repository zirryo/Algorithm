import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int d = scanner.nextInt();
        double k = scanner.nextDouble() / 100;
        double result = 0;
        scanner.close();

        double curWinRate = d / 100.0;
        double prevLoseRate = 1.0;

        for (int i = 1; ; i++) {
            result += i * a * prevLoseRate * curWinRate;
            // 기댓값 = n 번째 판에서 게임이 끝날 확률 * 걸린시간 = n-1판까지 게임을 질 확률 * n번째 판에서 이길 확률 * 걸린시간
            if (curWinRate == 1) break;

            prevLoseRate *= (1-curWinRate);
            curWinRate *= (1 + k);
            if (curWinRate >= 1) curWinRate = 1;

        }

        System.out.printf(String.valueOf(result));
    }
}