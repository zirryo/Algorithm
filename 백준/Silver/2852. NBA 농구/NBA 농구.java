import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] teamScore = new int[3];
        int[] winTime = new int[3];
        int prevTimeStamp = 0;
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int teamNum = Integer.parseInt(st.nextToken());

            StringTokenizer time = new StringTokenizer(st.nextToken(), ":");
            int MM = Integer.parseInt(time.nextToken());
            int SS = Integer.parseInt(time.nextToken());
            int curTimeStamp = MM * 60 + SS;

            if (i != 0) {
                if (teamScore[1] > teamScore[2]) {
                    winTime[1] += curTimeStamp - prevTimeStamp;
                } else if (teamScore[1] < teamScore[2]) {
                    winTime[2] += curTimeStamp - prevTimeStamp;
                }
            }
            prevTimeStamp = curTimeStamp;
            teamScore[teamNum]++;
        }

        if (teamScore[1] > teamScore[2]) {
            winTime[1] += (48 * 60 - prevTimeStamp);
        } else if (teamScore[2] > teamScore[1]) {
            winTime[2] += (48 * 60 - prevTimeStamp);
        }

        for (int i=1; i<=2; i++) {
            int resultM = winTime[i] / 60;
            int resultS = winTime[i] % 60;

            if (resultM < 10) sb.append(0);
            sb.append(resultM).append(":");
            if (resultS < 10) sb.append(0);
            sb.append(resultS).append("\n");
        }

        System.out.print(sb);
    }
}