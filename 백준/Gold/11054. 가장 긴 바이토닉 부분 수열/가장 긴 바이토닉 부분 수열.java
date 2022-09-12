import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] seq;
    static int[] i_dp; // LIS 값을 저장하는 배열
    static int[] d_dp; // LDS 값을 저장하는 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        seq = new int[N];
        i_dp = new int[N];
        d_dp = new int[N];

        for(int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        findLIS();
        findLDS();

        int max = 0;
        for(int i=0; i<N; i++) max = Math.max(max, i_dp[i] + d_dp[i]);
        System.out.println(max + 1); // 비교대상 인덱스도 수열에 포함되므로 + 1
    }

    static void findLIS() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(seq[j] < seq[i] && i_dp[j] + 1 > i_dp[i]) {i_dp[i] = i_dp[j] + 1;}
            }
        }
    }

    static void findLDS() {
        for(int i=N-1; i>=0; i--) {
            for(int j=N-1; j>i; j--) {
                if(seq[j] < seq[i] && d_dp[j] + 1 > d_dp[i]) {d_dp[i] = d_dp[j] + 1;}
            }
        }
    }
}