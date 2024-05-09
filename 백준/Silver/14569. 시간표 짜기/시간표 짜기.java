import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long[] timetable = new long[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int t = Integer.parseInt(st.nextToken());
                timetable[i] |= (1L << t);
            }
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            long student = 0L;
            for (int j = 0; j < p; j++) {
                int q = Integer.parseInt(st.nextToken());
                student |= (1L << q);
            }

            for (int j = 0; j < N; j++) {
                if ((~student & timetable[j]) == 0L) cnt++;
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}