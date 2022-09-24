import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[8001]; // 수 입력범위 -4000 ~ 4000

        int sum = 0;
        int max = -4000;
        int min = 4000;
        int median = 4001; // 범위에 없는 값으로 초기화
        int mode = 4001; // 범위에 없는 값으로 초기화

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[num+4000]++;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int cnt = 0; // 중앙값을 찾기 위한 카운트
        int modeMax = 0;
        boolean flag = false;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > 0) {

                if(cnt < (N/2) + 1) {
                    cnt += arr[i];
                    median = i - 4000;
                }

                if(modeMax < arr[i]) {
                    modeMax = arr[i];
                    mode = i - 4000;
                    flag = true;
                } else if (modeMax == arr[i] && flag) { // 최빈값 중 두번째로 작은 수 저장
                   mode = i - 4000;
                   flag = false;
                }
            }
        }
        System.out.println((int)Math.round((double)sum/N));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max - min);
    }
}