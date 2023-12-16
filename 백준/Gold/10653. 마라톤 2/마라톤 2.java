import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][],N,K, memo[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int [][]a = new int[N+1][2];
        for(int i =1; i<= N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0]= Integer.parseInt(st.nextToken());
            a[i][1]= Integer.parseInt(st.nextToken());
        }
        arr = new int[N+1][N+1];
        for(int i =1; i< N;i++) {
            for(int j =i+1; j<= N; j++) {
                arr[i][j] = Math.abs(a[i][0]-a[j][0])+Math.abs(a[i][1]-a[j][1]);
            }
        }
        memo = new int[N+1][K+1];
        System.out.println(check(N,K));
    }
    private static int check(int n,int k) {
        if(memo[n][k]!=0)return memo[n][k];
        if(n==1) return 0;
        memo[n][k] = Integer.MAX_VALUE;
        for(int i = 0; i<= k; i++) {
            if(0<n-i-1) memo[n][k] = Math.min(check(n-i-1,k-i)+arr[n-i-1][n],memo[n][k] );
        }
        return memo[n][k];
    }
}