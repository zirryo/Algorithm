import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Call {
    int start, end;

    public Call(int start, int duration) {
        this.start = start;
        this.end = start + duration;
    }

    public boolean overlaps(int s, int e) {
        return this.start < e && s < this.end;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 통화 수
            int M = Integer.parseInt(st.nextToken()); // 구간 수

            if (N == 0 && M == 0) break;

            List<Call> calls = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // Source (사용 안함)
                st.nextToken(); // Destination (사용 안함)
                int start = Integer.parseInt(st.nextToken());
                int duration = Integer.parseInt(st.nextToken());
                calls.add(new Call(start, duration));
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int intervalStart = Integer.parseInt(st.nextToken());
                int intervalDuration = Integer.parseInt(st.nextToken());
                int intervalEnd = intervalStart + intervalDuration;

                int count = 0;
                for (Call call : calls) {
                    if (call.overlaps(intervalStart, intervalEnd)) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }
}
