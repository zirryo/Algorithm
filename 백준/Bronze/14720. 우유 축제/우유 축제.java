import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] milkArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = 0;
        int milkIdx = 0;

        for (int i = 0; i < N; i++) {
            if (milkArr[i] == milkIdx) {
                result++;
                milkIdx = (milkIdx + 1) % 3;
            }
        }

        System.out.println(result);
    }
}