import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length()][s2.length()];
        int result = 0;

        for(int i=0; i<s1.length(); i++) {
            for(int j=0; j<s2.length(); j++) {

                if(s1.charAt(i) == s2.charAt(j)) {
                    if(i != 0 && j != 0) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        System.out.println(result);
    }

}