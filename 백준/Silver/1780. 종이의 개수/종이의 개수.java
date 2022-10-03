import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] paper;
    public static int minus = 0;
    public static int zero = 0;
    public static int plus = 0;
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
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);

    }
    public static void partition(int row, int col, int size) {
        if(isOneNum(row, col, size)) {
            if(paper[row][col] == -1) minus++;
            else if (paper[row][col] == 0) zero++;
            else plus++;
            return;
        }
        int part = size / 3;
        partition(row, col, part);
        partition(row, col + part, part);
        partition(row , col + 2*part, part);
        partition(row + part, col, part);
        partition(row + part, col + part, part);
        partition(row + part, col + 2*part, part);
        partition(row + 2*part, col, part);
        partition(row + 2*part, col + part, part);
        partition(row + 2*part, col + 2*part, part);
    }

    public static boolean isOneNum(int row, int col, int size) {
        int num = paper[row][col];

        for(int i=row; i<row+size; i++) {
            for(int j=col; j<col+size; j++) {
                if(paper[i][j] != num) return false;
            }
        }
        return true;
    }
}
