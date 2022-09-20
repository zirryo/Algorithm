import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int N = Integer.parseInt(str);
        int constructor = 0; // 생성자가 없는 경우 0 출력

        for(int i=(N-len*9); i<N; i++) {
            // 입력된 수에서 (길이 * 9) 값을 뺀 값이 생성자가 될 수 있는 최솟값
            int num = i;
            int sum = 0;

            while(num != 0) { // 각 자릿수의 합을 구함
                sum += num % 10;
                num /= 10;
            }

            if(sum + i == N) {
                constructor = i;
                break;
            }
        }
        System.out.println(constructor);
    }
}