import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            if (ticTacToe(input)) sb.append("valid\n");
            else sb.append("invalid\n");
        }
        System.out.print(sb);
    }
    private static boolean ticTacToe(String s) {
        char[][] map = new char[3][3];
        int X = 0;
        int O = 0;
        int xLine = 0;
        int oLine = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = s.charAt(i*3 + j);
                if (map[i][j] == 'X') X++;
                else if(map[i][j] == 'O') O++;
            }
        }

        if (O > X || Math.abs(O - X) >= 2) return false;

        for (int i = 0; i < 3; i++) {
            if (map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                if (map[i][0] == 'X') xLine++;
                else if (map[i][0] == 'O') oLine++;
            }
            if (map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                if (map[0][i] == 'X') xLine++;
                else if (map[0][i] == 'O') oLine++;
            }
        }
        if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
            if (map[1][1] == 'X') xLine++;
            else if (map[1][1] == 'O') oLine++;
        }
        if (map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
            if (map[1][1] == 'X') xLine++;
            else if (map[1][1] == 'O') oLine++;
        }

        if (xLine > 0) {
            if (oLine > 0) return false;
            return X - O == 1;
        }
        if (oLine > 0) {
            return X == O;
        }
        return X == 5 && O == 4;
    }
}