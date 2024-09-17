import java.io.*;
import java.util.*;

public class Main {

    public static int[] getScore(String guess, String target) {
        int strike = 0, ball = 0;
        for (int i = 0; i < 3; i++) {
            if (guess.charAt(i) == target.charAt(i)) {
                strike++;
            } else if (target.contains(guess.charAt(i) + "")) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] question = new String[N];
        int[] strikes = new int[N];
        int[] balls = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            question[i] = st.nextToken();
            strikes[i] = Integer.parseInt(st.nextToken());
            balls[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = 123; i <= 987; i++) {
            String candidate = String.valueOf(i);

            // 숫자에 0이 포함되거나 중복된 숫자가 있으면 건너뜀
            if (candidate.contains("0") || candidate.charAt(0) == candidate.charAt(1)
                    || candidate.charAt(1) == candidate.charAt(2)
                    || candidate.charAt(0) == candidate.charAt(2)) {
                continue;
            }

            // 각 질문에 대해 스트라이크와 볼의 수가 맞는지 확인
            boolean isValid = true;
            for (int j = 0; j < N; j++) {
                int[] score = getScore(question[j], candidate);
                if (score[0] != strikes[j] || score[1] != balls[j]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                count++;
            }
        }

        System.out.println(count);
    }
}
