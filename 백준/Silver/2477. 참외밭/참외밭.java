import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int melon = Integer.parseInt(br.readLine());
        int sum = 0;
        int maxArea = 0;

        st = new StringTokenizer(br.readLine());
        st.nextToken(); // 방향 정보는 필요없음.

        int first = Integer.parseInt(st.nextToken()); // 첫번째 변의 길이
        int d = first;

        // 모든 인접한 두 변의 곱으로 넓이를 구하여 더함
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int cur = Integer.parseInt(st.nextToken());
            int tempArea = cur * d;
            maxArea = Math.max(maxArea, tempArea); // 최댓값이 전체 사각형의 넓이
            sum += tempArea;
            d = cur;
        }
        maxArea = Math.max(maxArea, d*first);
        sum += d * first;
        // 육각형은 3번, 제외되는 밭의 넓이는 2번 중복되므로 전체 사각형의 넓이를 2번 빼면 육각형의 넓이를 구할 수 있음.
        System.out.println((sum - maxArea*2)*melon);
    }
}
