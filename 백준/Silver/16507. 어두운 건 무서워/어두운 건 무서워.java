import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] light, prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        light = new int[R+1][C+1];
        prefix = new int[R+1][C+1];
        for (int i=1; i<=R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=C; j++) {
                light[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makePrefixSum();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            sb.append(getLightAverage(r1, c1, r2, c2)).append("\n");
        }

        System.out.println(sb);
    }
    private static void makePrefixSum() {
        for (int i=1; i<=R; i++) {
            for (int j=1; j<=C; j++) {
                prefix[i][j] = light[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }
    }
    private static int getLightAverage(int r1, int c1, int r2, int c2) {
        int total = prefix[r2][c2] - prefix[r2][c1-1] - prefix[r1-1][c2] + prefix[r1-1][c1-1];
        int cnt = (r2 - r1 + 1) * (c2 - c1 + 1);
        return total / cnt;
    }
}