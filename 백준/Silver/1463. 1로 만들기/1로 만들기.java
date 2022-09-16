import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(recur(N,0));
    }
    static int recur(int N, int count) {
        if (N < 2) return count;
        return Math.min(recur(N / 2, count + 1 + (N % 2)), recur(N / 3, count + 1 + (N % 3)));
        // 카운트에 2, 3으로 나눈 나머지를 더하기 <- 나누어 떨어지지 않을 경우 -1 연산을 하는 것도 카운트에 포함됨
    }
}
