import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] homes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        homes = new int[N];

        for(int i=0; i<N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes); // 이분 탐색을 위해 오름차순 정렬

        int low = 1;
        int high = homes[N-1] - homes[0] + 1;

        while(low < high) {
            int mid = (low + high) / 2;

            if(routers(mid) < C) high = mid; // 공유기 설치 개수가 적다 == 공유기 간의 거리가 너무 멀다
            else low = mid + 1;
        }
        System.out.println(low-1);

    }

    // 길이 d 에 따른 공유기 설치 가능 대수를 구하는 메소드
    public static int routers(int d) {
        int cnt = 1;
        int lasthome = homes[0]; // 최대 거리 -> 첫번째 집에는 반드시 설치

        for(int h=1; h < homes.length; h++) {
            int temp = homes[h];
            if(temp - lasthome >= d) {
                cnt++;
                lasthome = temp;
            }
        }
        return cnt;
    }
}