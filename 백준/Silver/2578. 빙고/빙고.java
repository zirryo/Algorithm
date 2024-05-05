import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        board = new boolean[5][5];
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int k = Integer.parseInt(st.nextToken());
                map.put(k, i * 5 + j);
            }
        }

        Outer:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = map.get(x);
                board[y/5][y%5] = true;
                if (i < 2) continue;
                if (makeThreeBingo()) {
                    result = i * 5 + j + 1;
                    break Outer;
                }
            }
        }

        System.out.println(result);

    }
    private static boolean makeThreeBingo() {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            boolean flag = true;
            for (int j = 0; j < 5; j++) {
                if (!board[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        for (int i = 0; i < 5; i++) {
            boolean flag = true;
            for (int j = 0; j < 5; j++) {
                if (!board[j][i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }

        boolean cross = true;
        for (int i=0; i<5; i++) {
            if (!board[i][i]) {
                cross = false;
                break;
            }
        }
        if (cross) cnt++;
        cross = true;
        for (int i=0; i<5; i++) {
            if (!board[i][4-i]) {
                cross = false;
                break;
            }
        }
        if (cross) cnt++;

        return cnt >= 3;
    }
}