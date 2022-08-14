// 조합과 동적 프로그래밍
// 재귀 + 배열에 계산한 값 저장하여 중복 계산 방지
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N+1][R+1];
        System.out.println(nCr(N,R));

    }
    static int nCr (int n, int r) {
        if(arr[n][r]>0) return arr[n][r];
        else if(n==r || r==0) return arr[n][r] = 1;
        return arr[n][r] = nCr(n-1,r) + nCr(n-1,r-1);
    }
}