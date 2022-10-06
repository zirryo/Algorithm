import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int mod = 1000;
    public static int N;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % mod; // 모듈러 연산을 적용하여 초기화
            }
        }
        int[][] result = pow(arr, B);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    public static int[][] pow(int[][] A, long exp) {
        if(exp == 1L) return A;
        int[][] temp = pow(A, exp/2);

        temp = multiple(temp, temp);

        if(exp % 2 == 1L) temp = multiple(temp, arr);
        return temp;
    }

    public static int[][] multiple(int[][] a1, int[][] a2) {
        int[][] temp = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    temp[i][j] += a1[i][k] * a2[k][j];
                    temp[i][j] %= mod;
                }
            }
        }
        return temp;
    }
}