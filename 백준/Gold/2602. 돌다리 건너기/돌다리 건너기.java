import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] order = br.readLine().toCharArray();
        char[] angel = br.readLine().toCharArray();
        char[] devil = br.readLine().toCharArray();

        int orderLen = order.length;
        int bridgeLen = angel.length;

        int[][][] dp = new int[orderLen + 1][2][bridgeLen + 1];

        for (int i = 0; i < bridgeLen; i++) {
            if (angel[i] == order[0]) {
                dp[1][0][i + 1] = 1;  // 천사 다리에서 시작
            }
            if (devil[i] == order[0]) {
                dp[1][1][i + 1] = 1;  // 악마 다리에서 시작
            }
        }

        for (int i = 1; i < orderLen; i++) {
            for (int j = 0; j < bridgeLen; j++) {
                // 현재 문자가 order의 i번째 문자일 때
                if (angel[j] == order[i]) {
                    // 천사 다리에서 j번째에서 i번째 문자를 만들 때
                    for (int k = 0; k < j; k++) {
                        dp[i + 1][0][j + 1] += dp[i][1][k + 1];  // 이전에 악마 다리에서 i-1번째 문자를 만들었음
                    }
                }
                if (devil[j] == order[i]) {
                    // 악마 다리에서 j번째에서 i번째 문자를 만들 때
                    for (int k = 0; k < j; k++) {
                        dp[i + 1][1][j + 1] += dp[i][0][k + 1];  // 이전에 천사 다리에서 i-1번째 문자를 만들었음
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= bridgeLen; i++) {
            result += dp[orderLen][0][i];  // 천사 다리에서 주문서의 마지막 문자를 만들 수 있는 경우
            result += dp[orderLen][1][i];  // 악마 다리에서 주문서의 마지막 문자를 만들 수 있는 경우
        }

        System.out.println(result);
    }
}

