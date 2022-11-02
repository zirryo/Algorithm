import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 투 포인터 이용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수
        int S = Integer.parseInt(st.nextToken()); // 최소 합

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int result = Integer.MAX_VALUE;
        int point1 = 0;
        int point2 = 0;
        int sum = 0;

        while(point1 <= N && point2 <= N) {
            if(sum >= S && result > point2 - point1) {
                result = point2 - point1; // 결과값 갱신
            }
            
            if(sum < S) sum += arr[point2++];
            else sum -= arr[point1++];
        }
        
        if(result == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(result);
    }
}