import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] A;
    static int[][] B;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for(int i=0; i<N; i++) {
            String sa = br.readLine();
            for(int j=0; j<M; j++) {
                A[i][j] = sa.charAt(j) - '0';
            }
        }
        for(int i=0; i<N; i++) {
            String sb = br.readLine();
            for(int j=0; j<M; j++) {
                B[i][j] = sb.charAt(j) - '0';
            }
        }

        if(N < 3 || M < 3) { // 뒤집을 수 없는 경우
            if(!isSame(A, B)) cnt = -1;
        } else { // 뒤집을 수 있는 경우
            getCnt();
            if(!isSame(A, B)) cnt = -1; // 뒤집어도 B 행렬을 만들 수 없음
        }

        System.out.println(cnt);
    }

    private static void getCnt() {
        for(int i=0; i<N-2; i++) {
            for(int j=0; j<M-2; j++) {
                if(A[i][j] != B[i][j]) {
                    flip(i, j);
                    cnt++;
                }
            }
        }
    }

    private static boolean isSame(int[][] A, int[][] B) { // 두 행렬이 같은 행렬인 지 확인
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }

    private static void flip(int y, int x) { // 3X3 행렬 뒤집기
        for(int i=y; i<y+3; i++) {
            for(int j=x; j<x+3; j++) {
                if(A[i][j]==0) A[i][j] = 1;
                else A[i][j] = 0;
            }
        }
    }

}