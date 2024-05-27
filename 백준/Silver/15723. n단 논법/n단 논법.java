import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] isTrue = new boolean[26][26];
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int y = st.nextToken().charAt(0) - 'a';
            isTrue[x][y] = true;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (isTrue[i][k] && isTrue[k][j]) {
                        isTrue[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int y = st.nextToken().charAt(0) - 'a';

            sb.append(isTrue[x][y] ? "T\n" : "F\n");
        }
        System.out.println(sb);
    }
}