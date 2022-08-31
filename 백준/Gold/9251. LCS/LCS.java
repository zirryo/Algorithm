import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int len1 = str1.length;
        int len2 = str2.length;
        int[][] dp = new int[len1 + 1][len2 + 1]; // -1 인덱스 참조를 막기위해 배열 크기 +1

        for(int i=1; i<=len1; i++) { // i=0 은 공집합
            for(int j=1; j<=len2; j++) { // j=0 은 공집합
                // char[] 는 인덱스가 0부터 값이 시작되므로 index-1
                if(str1[i-1] == str2[j-1]) dp[i][j] = dp[i-1][j-1] + 1; // char 가 같다면 LCS 길이 +1
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); // 같지 않다면 이전 행/열 값 중 큰 값 대입
            }
        }
        System.out.println(dp[len1][len2]);
    }
}