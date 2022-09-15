import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 카운팅 정렬 방식 이용, 입력 범위 -1000~1000 이므로 크기 2001의 배열 사용
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        boolean arr[] = new boolean[2001];
        for(int i=0; i<N; i++) {
            arr[Integer.parseInt(br.readLine())+1000] = true;
        }
        for(int i=0; i<2001; i++) {
            if(arr[i]) sb.append(i-1000).append("\n");
        }
        System.out.println(sb);
    }
}