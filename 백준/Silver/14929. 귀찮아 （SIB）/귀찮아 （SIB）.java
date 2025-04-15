import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        long totalSum = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            totalSum += A[i];
        }

        long answer = 0;

        for (int i = 0; i < N - 1; i++) {
            totalSum -= A[i];
            answer += (long) A[i] * totalSum;
        }

        System.out.println(answer);
    }
}
