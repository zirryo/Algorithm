import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int num = 1;
        int removed = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == num) {
                num++;
            } else {
                removed++;
            }
        }

        System.out.println(removed);
    }
}