import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long result = 0L;
        for (int i=1; i<=N; i++) {
            result += (N / i) * i;
        }
        System.out.println(result);
    }
}
/*
g(x) = f(1) + f(2) + ... + f(x-1) + f(x)

x 이하의 자연수 중에서
 - 1을 약수로 갖는 수의 개수 : x / 1 (개)
 - 2을 약수로 갖는 수의 개수 : x / 2 (개)
 - 3을 약수로 갖는 수의 개수 : x / 3 (개)
 - ...
 - x을 약수로 갖는 수의 개수 : x / x (개)

 g(x) = (x/1) * 1 + (x/2) * 2 + (x/3) * 3 + ... + (x/x) * x
 */