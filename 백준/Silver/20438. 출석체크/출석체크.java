import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] sleeping = new boolean[N + 3];
        boolean[] receivedCode = new boolean[N + 3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int student = Integer.parseInt(st.nextToken());
            sleeping[student] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int student = Integer.parseInt(st.nextToken());
            if (!sleeping[student]) {
                for (int j = student; j <= N + 2; j += student) {
                    if (!sleeping[j]) receivedCode[j] = true;
                }
            }
        }

        int[] notPresent = new int[N + 3]; // 출석하지 않은 학생 수 누적합
        for (int i = 3; i <= N + 2; i++) {
            notPresent[i] = notPresent[i - 1];
            if (!receivedCode[i]) {
                notPresent[i]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(notPresent[end] - notPresent[start - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
