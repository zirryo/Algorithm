import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int maxLen = Math.min(N, M);

        Outer:
        while (maxLen-- > 1) {
            for (int i = 0; i < N-maxLen; i++) {
                for (int j = 0; j < M-maxLen; j++) {
                    int point = arr[i][j];
                    if (point == arr[i][j+maxLen] && point == arr[i+maxLen][j] &&
                            point == arr[i+maxLen][j+maxLen]) {
                        break Outer;
                    }
                }
            }
        }

        maxLen++;
        System.out.println(maxLen * maxLen);
    }
}