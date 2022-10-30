import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] nums = {1, 2, 3, 5, 7, 9};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dfs("", 0);
        System.out.println(sb);
    }

    private static void dfs(String s, int depth) {
        if(depth == N) {
            sb.append(s).append("\n");
            return;
        }
        for(int i=0; i< nums.length; i++) {
            String temp = s + nums[i];
            if(isPrime(Integer.parseInt(temp))) {
                dfs(temp, depth+1);
            }
        }
    }

    private static boolean isPrime(int K) {
        if(K<=1) return false;
        for(int i=2; i<=Math.sqrt(K); i++) {
            if(K%i == 0) return false;
        }
        return true;
    }
}
