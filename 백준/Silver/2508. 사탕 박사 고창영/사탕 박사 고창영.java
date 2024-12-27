import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            char[][] map = new char[r][c];
            for (int i = 0; i < r; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int candy = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c - 2; j++) {
                    if (map[i][j] == '>' && map[i][j+1] == 'o' && map[i][j+2] == '<') {
                        candy++;
                    }
                }
            }

            for (int i = 0; i < r - 2; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] == 'v' && map[i+1][j] == 'o' && map[i+2][j] == '^') {
                        candy++;
                    }
                }
            }

            result.append(candy).append("\n");
        }

        System.out.print(result);
    }
}
