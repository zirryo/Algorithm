import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 전체 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 종류
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N];
        int[] eat = new int[d+1]; // 특정 스시를 몇번 먹었는지 체크

        for(int i=0; i<N; i++) sushi[i] = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i=0; i<k; i++) {
            if(eat[sushi[i]] == 0) cnt++; // 0번째 초밥부터 k개를 먹으면서, 안먹은 초밥일 경우 카운트
            eat[sushi[i]]++; // 각 초밥의 먹은 개수 카운트
        }

        int result = cnt; // 0~K-1 카운트 값으로 결과값 초기화

        for(int i=1; i<N; i++) {
            if(result <= cnt) {
                if(eat[c] == 0) result = cnt + 1;
                else result = cnt;
            }

            int point = (i + k - 1) % N; // 배열의 끝 -> 앞으로 이어지므로 나머지 연산

            if(eat[sushi[point]] == 0) cnt++; // 새로운 초밥이라면 카운트
            eat[sushi[point]]++;

            eat[sushi[i-1]]--; // 지나간 초밥 제거
            if(eat[sushi[i-1]] == 0) cnt--;
        }
        System.out.println(result);
    }

}