import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] counting = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 오름차순으로 카운팅 정렬
        for(int i=0; i<N; i++) {
            int time = Integer.parseInt(st.nextToken());
            counting[time]++;
        }

        int sum = 0;
        int idx = N;
        // 가장 작은 수 * N회 + 두번째로 작은 수 * N-1회 + ... = 최솟값
        for(int i=1; i< counting.length; i++) {
            if(idx>0) {
                while(counting[i]-- > 0) {
                    sum += (i * idx);
                    idx--;
                }
            }
            else break;
        }
        System.out.println(sum);
    }
}