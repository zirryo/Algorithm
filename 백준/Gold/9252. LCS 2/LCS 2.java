import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] ch1, ch2;
    static int[][] dp;
    static int len1, len2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();
        int LCS = getLCS();
        sb.append(LCS).append("\n");
        printLCS(len1, len2);
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ch1 = br.readLine().toCharArray();
        ch2 = br.readLine().toCharArray();
    }
    private static int getLCS() {
        len1 = ch1.length;
        len2 = ch2.length;
        dp = new int[len1 + 1][len2 + 1]; // -1 인덱스 참조를 막기위해 배열 크기 +1

        for(int i=1; i<=len1; i++) {
            for(int j=1; j<=len2; j++) {
                if(ch1[i-1] == ch2[j-1]) dp[i][j] = dp[i-1][j-1] + 1; // char 가 같다면 LCS 길이 +1
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); // 같지 않다면 이전 행/열 값 중 큰 값 대입
            }
        }
        return dp[len1][len2];
    }
    private static void printLCS(int i, int j) {
        if(dp[i][j] == 0) return;

        if(ch1[i-1] == ch2[j-1]) {
            printLCS(i-1, j-1);
            sb.append(ch1[i-1]);
        } else if (dp[i-1][j] > dp[i][j-1]) {
            printLCS(i-1, j);
        } else if (dp[i-1][j] <= dp[i][j-1]) {
            printLCS(i, j-1);
        }

    }
}