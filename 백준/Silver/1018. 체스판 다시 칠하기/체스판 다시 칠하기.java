import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[][] arr;
    public static int result = 64;
    // 최솟값을 구하는 문제이므로 경우의 수 중 가장 큰 값을 초기값으로 지정.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];
        // 입력을 boolean 배열로 변환
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                if(s.charAt(j)=='W') arr[i][j] = true;
                else arr[i][j] = false;
            }
        }
        for(int i=0; i<N-7; i++) { // 주어진 입력이 8*8 보다 큰 경우 다른 경우 까지 탐색하면서 최소값을 찾기
            for(int j=0; j<M-7; j++) {
                fixChessboard(i,j);
            }
        }
        System.out.println(result);


    }

    public static void fixChessboard(int i, int j) {
        int cnt = 0;
        boolean basePoint = arr[i][j];
        for(int k=i; k<=i+7; k++) {
            for(int l=j; l<=j+7; l++) {
                if(arr[k][l] != basePoint) cnt++;
                basePoint = !basePoint;
            }
            // 체스판 8*8이므로 줄 단위가 짝수, 따라서 특정 행의 마지막 자리와 그 다음 행의 색이 같음.
            // 따라서, 행이 바뀔 때마다 다시 색 교환 필요.
            basePoint = !basePoint;
        }
        cnt = Math.min(cnt, 64-cnt);
        // basePoint==W,B 인 경우 중 더 카운트가 작은 경우 찾기
        result = Math.min(cnt, result);
        // 함수의 결과를 계속해서 더 작은 값으로 갱신
        
        
    }
}
