import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());


        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        int cur = m;
        int exercise = 0;
        int time = 0;

        while (exercise < N) {
            if (cur + T <= M) {
                cur += T;
                exercise++;
            } else {
                cur = Math.max(m, cur - R);
            }
            time++;
        }

        System.out.println(time);
    }
}
