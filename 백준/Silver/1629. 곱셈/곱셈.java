import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력되는 수 A,B,C 의 최댓값은 int 의 max value 이므로 범위를 벗어나지 않도록 주의
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B));
    }
    public static long pow(long A, long exp) {
        if(exp == 1) return A % C;
        long temp = pow(A, exp/2);

        if(exp % 2 == 1) return (temp * temp % C) * A % C;
        return temp * temp % C;
    }
}
