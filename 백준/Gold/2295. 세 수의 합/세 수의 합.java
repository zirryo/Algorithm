import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sum = new int[N*N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int idx = 0;
        int result = 0;

        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                sum[idx] = arr[i] + arr[j]; // x + y 값을 담은 배열 생성
                idx++;
            }
        }

        Arrays.sort(sum);

        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                int x = arr[j] - arr[i];

                int l = sum.length - idx; // 0이 아닌수의 시작점
                int r = sum.length - 1;

                // x + y 배열 이진 탐색 -> 최댓값 도출
                while(l <= r) {
                    int mid = (l+r) / 2;
                    int y = sum[mid];

                    if(x > y) {
                        l = mid + 1;
                    } else if(x < y) {
                        r = mid - 1;
                    } else {
                        result = Math.max(result, arr[j]);
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}