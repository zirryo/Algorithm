import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        int questionCnt = 0;

        for (int i = 0; i < N/2; i++) {
            char forward = input[i];
            char backward = input[N-1-i];

            if (forward == backward) {
                if (forward == '?') questionCnt += 26;
            } else {
                if (forward == '?' || backward == '?') {
                    questionCnt++;
                } else {
                    questionCnt = 0;
                    break;
                }
            }
        }

        System.out.println(questionCnt);
    }
}