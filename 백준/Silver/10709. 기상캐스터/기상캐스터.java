import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] map = new char[H][W];
        int[][] result = new int[H][W];

        for (int i = 0; i < H; i++) {
            Arrays.fill(result[i], -1);
        }

        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            int cnt = 0;
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] =='c') {
                    result[i][j] = 0;
                    cnt = 1;
                } else if (cnt != 0){
                    result[i][j] = cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}