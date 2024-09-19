import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String initial = br.readLine();
            String target = br.readLine();

            int countW = 0; // 초기상태에서 목표상태와 다르게 배치된 W의 수
            int countB = 0; // 초기상태에서 목표상태와 다르게 배치된 B의 수

            for (int i = 0; i < N; i++) {
                if (initial.charAt(i) != target.charAt(i)) {
                    if (initial.charAt(i) == 'W') {
                        countW++;
                    } else {
                        countB++;
                    }
                }
            }

            int minSwaps = Math.min(countW, countB); // 교환으로 해결할 수 있는 부분
            int remaining = Math.abs(countW - countB); // 남은 부분은 뒤집어야함

            sb.append(minSwaps + remaining).append("\n");
        }

        System.out.print(sb);
    }
}
