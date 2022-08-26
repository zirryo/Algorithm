// 재귀를 이용하여 (현위치 값 + 아래row의 두 값 중 큰 값) 을 dp 배열에 저장하여 [0][0]에 도달
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int dp[][];
    static int arr[][];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];


        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            if(i != N-1) Arrays.fill(dp[i],-1);
            dp[N-1][i] = arr[N-1][i];
        }
        System.out.println(maxSum(0,0));
    }
    static int maxSum(int depth, int index) {
        if(depth == N-1) return dp[depth][index];

        if(dp[depth][index]<0) {
            dp[depth][index] = Math.max(maxSum(depth+1,index),maxSum(depth+1,index+1)) + arr[depth][index];
        }
        return dp[depth][index];
    }
}