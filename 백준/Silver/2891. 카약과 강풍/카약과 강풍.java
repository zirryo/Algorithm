import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 팀의 수
        int S = Integer.parseInt(st.nextToken()); // 카약이 손상된 팀의 수
        int R = Integer.parseInt(st.nextToken()); // 카약을 하나 더 가져온 팀의 수
        boolean[] sArr = new boolean[12];
        boolean[] rArr = new boolean[12];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int x = Integer.parseInt(st.nextToken());
            sArr[x] = true;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int y = Integer.parseInt(st.nextToken());
            rArr[y] = true;
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!sArr[i]) continue;
            if (rArr[i]) {
                rArr[i] = false;
                continue;
            }
            if (rArr[i-1]) {
                rArr[i-1] = false;
                continue;
            }
            if (rArr[i+1] && !sArr[i+1]) {
                rArr[i+1] = false;
                continue;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}