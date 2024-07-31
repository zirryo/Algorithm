import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static String[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = new String[37];
        for (int i=1; i<=36; i++) {
            input[i] = br.readLine();
        }
        if (knightTour()) System.out.println("Valid");
        else System.out.println("Invalid");
    }
    private static boolean knightTour() {
        boolean[][] visited = new boolean[6][6];
        int[] start = new int[2];
        int[] prev = {-1, -1};
        for (int i = 1; i <= 36; i++) {
            String line = input[i];
            int row = line.charAt(0) - 'A';
            int col = line.charAt(1) - '1';
            if (i != 1) {
                int distR = Math.abs(prev[0] - row);
                int distC = Math.abs(prev[1] - col);
                if (visited[row][col] || (distR + distC) != 3 || distC >= 3 || distR >= 3) {
                    return false;
                }
            } else {
                start[0] = row;
                start[1] = col;
            }
            visited[row][col] = true;
            prev[0] = row;
            prev[1] = col;
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (!visited[i][j]) {
                    return false;
                }
            }
        }

        int distR = Math.abs(prev[0] - start[0]);
        int distC = Math.abs(prev[1] - start[1]);
        return (distR + distC == 3) && distR < 3 && distC < 3;
    }
}