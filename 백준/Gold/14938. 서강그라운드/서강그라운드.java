import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int maxRange = 16;
        int result = 0;

        int[] item = new int [n+1];
        int[][] map = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) item[i] = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                map[i][j] = maxRange;
            }
        }

        for(int i=1; i<=r; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[s][e] = v;
            map[e][s] = v;
        }

        for(int k=1; k<=n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(i==j || j==k || k==i) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for(int i=1; i<=n; i++) {
            int temp = item[i];
            for(int j=1; j<=n; j++) {
                if(map[i][j] <= m) temp += item[j];
            }
            result = Math.max(result, temp);
        }
        System.out.println(result);
    }

}