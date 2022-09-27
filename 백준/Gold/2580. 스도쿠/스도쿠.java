import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];

        for(int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0, 0);
    }
    public static void sudoku(int row, int col) {
        if(col == 9) { // 행이 모두 채워진 경우
            sudoku(row+1,0);
            return;
        }

        if(row == 9) { // 행과 열이 모두 채워진 경우
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(arr[row][col] == 0) {
            for(int i=1; i<=9; i++) {
                if(isPossible(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }
        sudoku(row, col+1);
    }

    public static boolean isPossible(int row, int col, int num) {

        // 같은 행 검사
        for(int i=0; i<9; i++) {
            if(num == arr[row][i]) return false;
        }

        // 같은 열 검사
        for(int i=0; i<9; i++) {
            if(num == arr[i][col]) return false;
        }

        // 같은 칸(3*3) 검사
        int partRow = (row / 3) * 3; // num 이 속한 칸의 첫 row
        int partCol = (col / 3) * 3; // num 이 속한 칸의 첫 col
        for(int i=partRow; i<partRow+3; i++) {
            for(int j=partCol; j<partCol+3; j++) {
                if(num == arr[i][j]) return false;
            }
        }
        return true;
    }
}