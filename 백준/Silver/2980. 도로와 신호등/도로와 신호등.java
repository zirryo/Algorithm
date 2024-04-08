import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int curPos = 0;
        int curTime = 0;
        int d, r, g;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            int cycle = r + g;

            curTime += (d - curPos);
            if ((curTime % cycle) < r) curTime += (r - curTime % cycle);

            curPos = d;
        }

        curTime += (L - curPos);
        System.out.println(curTime);
    }
}