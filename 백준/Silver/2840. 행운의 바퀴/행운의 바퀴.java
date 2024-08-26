import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');  // 모든 칸을 '?'로 초기화

        boolean[] used = new boolean[26];  // 알파벳 사용 여부 체크
        int currentPos = 0;  // 현재 위치 (초기 위치는 0)

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());  // 시계방향으로 회전할 칸 수
            char letter = st.nextToken().charAt(0);  // 해당 칸에 적을 알파벳

            currentPos = (currentPos - S % N + N) % N;

            if (wheel[currentPos] != '?' && wheel[currentPos] != letter) {
                System.out.println("!");
                return;
            }

            if (wheel[currentPos] == '?') {
                if (used[letter - 'A']) {
                    System.out.println("!");
                    return;
                }
                wheel[currentPos] = letter;
                used[letter - 'A'] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(wheel[(currentPos + i) % N]);
        }

        System.out.println(result);
    }
}
