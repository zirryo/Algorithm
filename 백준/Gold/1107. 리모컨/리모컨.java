import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int channel = 100;
    static boolean[] broken = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 목표 채널
        int M = Integer.parseInt(br.readLine()); // 고장난 채널의 개수

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (M-- > 0) {
                int K = Integer.parseInt(st.nextToken());
                broken[K] = true;
            }
        }

        int result = Math.abs(N - channel); // 고장난 버튼 없이 +, - 이동만 하는 경우

        for(int i=0; i<=999999; i++) { // 완전 탐색, 9번 버튼만 활성화 되어 있는 경우 999999에서 이동해야 힘.
            String s = String.valueOf(i);
            int LEN = s.length();
            boolean flag = false;

            for(int j=0; j<LEN; j++) {
                if(broken[s.charAt(j)-'0']) {
                    flag = true;
                    break; // 고장난 버튼이 있을 경우 탐색 중지
                }
            }
            if(!flag) {
                int min = Math.abs(N - i) + LEN;
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}