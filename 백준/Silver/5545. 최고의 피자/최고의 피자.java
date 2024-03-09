import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 도우의 가격
        int B = Integer.parseInt(st.nextToken()); // 토핑의 가격
        int C = Integer.parseInt(br.readLine()); // 도우의 열량
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(D);

        int calories = C / A;
        int priceSum = A;
        int calSum = C;

        for (int i = N-1; i >= 0; i--) {
            priceSum += B;
            calSum += D[i];

            int temp = calSum / priceSum;
            if (calories > temp) {
                break;
            } else {
                calories = temp;
            }
        }

        System.out.println(calories);
    }
}