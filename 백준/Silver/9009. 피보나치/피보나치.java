import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] fibo = new int[43]; 
        // 1 ≤ n ≤ 1,000,000,000 이므로  약 43개의 피보나치 수로 이 범위를 커버할 수 있음
        fibo[0] = 1;
        fibo[1] = 2;
        for (int i=2; i<43; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        for (int i=0; i<N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int x = Integer.parseInt(br.readLine());

            for (int j=42; j>=0; j--) {
                if (x < fibo[j]) continue;
                list.add(fibo[j]);
                x -= fibo[j];

                if (x <= 0) break;
            }

            Collections.sort(list);
            for (int y : list) sb.append(y).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

// https://jeonggyun.tistory.com/232 : 최적해를 구하는 방식 참고