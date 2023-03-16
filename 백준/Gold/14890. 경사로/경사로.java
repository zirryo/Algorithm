import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, result = 0;
    static int[][] board1, board2;
    public static void main(String[] args) throws IOException {
        init();
        result += makeRoad(board1);
        result += makeRoad(board2);
        System.out.println(result);
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        board1 = new int[N][N];
        board2 = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board1[i][j] = Integer.parseInt(st.nextToken());
                board2[j][i] = board1[i][j];
            }
        }
    }
    private static int makeRoad(int[][] board) {
        int roads = 0;
        for(int i=0; i<N; i++) {
            boolean road = true;
            int baseLoadLen = 1; // 경사로를 놓을 바닥의 길이 (L 이상이어야 경사로 놓을 수 있음)
            for(int j=0; j<N-1; j++) {
                if(Math.abs(board[i][j] - board[i][j+1]) > 1) {
                    road = false;
                    break;
                } else if(board[i][j] == board[i][j+1]) {
                    baseLoadLen++;
                } else if(board[i][j] == board[i][j+1] + 1) { // 내리막
                    if(downHill(i, j, board)) {
                        j += (L-1);
                        baseLoadLen = 0;
                    } else {
                        road = false;
                        break;
                    }
                } else if (board[i][j] + 1 == board[i][j+1]) { // 오르막
                    if(baseLoadLen >= L) baseLoadLen = 1; // 경사로를 놓기 && 바닥 길이 리셋
                    else {
                        road = false;
                        break;
                    }
                }
            }

            if(road) roads++;
        }
        return roads;
    }
    private static boolean downHill(int i, int j, int[][] board) {
        int base = board[i][j+1];
        int len = 1;
        for(int k=j+2; k<j+1+L; k++) {
            if(k >= N || board[i][k] != base) {
                break;
            } else len++;
        }
        if(len >= L) return true;
        else return false;
    }
}