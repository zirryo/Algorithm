import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[][] map = new char[h][n*w];

        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (map[j][i*w+k] != '?') {
                        sb.append(map[j][i*w+k]);
                        continue Outer;
                    }
                }
            }
            sb.append("?");
        }

        System.out.println(sb);
    }
}