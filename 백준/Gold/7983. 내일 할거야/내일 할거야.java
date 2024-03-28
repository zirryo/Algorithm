import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] tasks = new int[N][2];
        StringTokenizer st;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            tasks[i][0] = Integer.parseInt(st.nextToken());
            tasks[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tasks, ((o1, o2) -> o2[1] - o1[1])); // 마감일 내림차순 정렬

        int lastDay = 1_000_000_001;

        for (int i = 0; i < N; i++) {
            if (lastDay < tasks[i][1]) {
                lastDay -= tasks[i][0];
            } else {
                lastDay = tasks[i][1] - tasks[i][0];
            }
        }

        System.out.println(lastDay);
    }
}