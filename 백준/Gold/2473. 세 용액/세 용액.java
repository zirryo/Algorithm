import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long minSum = Long.MAX_VALUE;
        long[] result = new long[3];
        // 배열의 각 원소 기준 ->  나머지 두 개의 원소를 투포인터 탐색
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];

                if (Math.abs(sum) < Math.abs(minSum)) {
                    minSum = sum;
                    result[0] = arr[i];
                    result[1] = arr[left];
                    result[2] = arr[right];
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
