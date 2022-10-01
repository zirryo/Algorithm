import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] paper;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                paper[i][j] = s.charAt(j) - '0';
            }
        }
        partition(0,0, N);
        System.out.println(sb);
    }
    public static void partition(int row, int col, int size) {
        if(isOneColor(row, col, size)) {
            sb.append(paper[row][col]);
            return;
        }

        int half = size / 2;

        sb.append("(");
        partition(row, col, half);
        partition(row, col+half, half);
        partition(row+half, col, half);
        partition(row+half, col+half, half);
        sb.append(")");
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