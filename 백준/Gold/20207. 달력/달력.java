import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] task = new int[366];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = a; j <= b; j++) {
                task[j]++;
            }
        }

        int result = 0;
        int maxTask = 0;
        int dayCnt = 0;

        for (int day = 1; day <= 365; day++) {
            if (task[day] == 0) {
                result += (maxTask * dayCnt);
                maxTask = 0;
                dayCnt = 0;
            } else {
                dayCnt++;
                maxTask = Math.max(maxTask, task[day]);
            }
        }

        result += (maxTask * dayCnt);
        System.out.println(result);
    }
}