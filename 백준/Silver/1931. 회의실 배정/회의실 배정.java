import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        // 종료 시간을 기준으로 배열 정렬, 종료시간이 같은 경우 시작시간이 빠른 경우가 우선
        Arrays.sort(time, (e1, e2) -> {
            if(e1[1] == e2[1]) return e1[0] - e2[0];
            else return e1[1] - e2[1];
        });

        int meeting = 0;
        int prev = 0;
        // 다음 회의 시작 시간이 이전 회의 종료시간과 같거나 그 후라면 배정 가능
        for(int i=0; i<N; i++) {
            if(prev <= time[i][0]) {
                prev = time[i][1];
                meeting++;
            }
        }
        System.out.println(meeting);
    }
}