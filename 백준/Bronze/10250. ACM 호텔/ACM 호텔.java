import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // bufferedReader 는 한 줄 단위로 읽음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 형태 1st line == testcase 개수 (T)
        //             n line(n=2,3,4...) 호텔 층 수 / 층별 방 수 / 호수를 구할 손님
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int floor = N % H;
            int roomNum = N / H;
            if(floor==0) System.out.println(H*100 + roomNum);
            else System.out.println(floor*100 + roomNum + 1);
        }
    }
}