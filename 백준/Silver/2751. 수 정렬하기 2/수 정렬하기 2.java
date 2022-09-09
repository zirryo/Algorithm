import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2000001];

        for(int i=0; i<N; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
            // 입력 범위가 -1,000,000 ~ 1,000,000 이므로 값과 배열 인덱스를 맞추기 위해 +1,000,000
        }

        StringBuilder sb = new StringBuilder();
        int j = 1;
        for(int i=0; i< arr.length; i++) {
            if(arr[i]) {
                j++;
                sb.append(i-1000000).append("\n"); // 값 출력을 위해 다시 -1,000,000
            }
            if(j>N) break;
        }
        System.out.println(sb);

    }
}