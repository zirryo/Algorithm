import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int white = 0;
    public static int blue = 0;
    public static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void partition(int row, int col, int size) {
        if(isOneColor(row, col, size)) {
            if(paper[row][col] == 0) white++;
            else blue++;
            return;
        }

        int half = size / 2;
        partition(row, col, half);
        partition(row, col+half, half);
        partition(row+half, col, half);
        partition(row+half, col+half, half);
    }
    public static boolean isOneColor(int row, int col, int size) {
        int color = paper[row][col]; // 구역의 (0,0)을 기준색으로 정함

        for(int i=row; i<row+size; i++) {
            for(int j=col; j<col+size; j++) {
                if(paper[i][j] != color) return false; // 구역 내에 기준색과 다른색이 있을경우 false
            }
        }
        return true; // 구역 안에 모두 같은 색만 존재 (추가 분할 필요 X)
    }
}