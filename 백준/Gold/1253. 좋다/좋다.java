import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for(int i=0; i<N; i++) {
            int good = arr[i]; // 두 수를 더해서 good 을 만들어야 함
            int left = 0;
            int right = N-1;

            while(left < right) {
                int temp = arr[left] + arr[right];
                if(temp == good) {
                    if(left != i && right != i) { // 0일때 자기 자신을 더해서 good 을 만드는 경우를 피하기 위함
                        cnt++;
                        break;
                    } else if (left == i) {
                        left++;
                    } else right--;
                } else if (temp < good) {
                    left++;
                } else right--;
            }
        }
        System.out.println(cnt);
    }
}