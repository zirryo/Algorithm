import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 카운팅 정렬 : 정렬해야 하는 수의 범위가 수의 개수에 비해 적은 편일 때 사용
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int counting[] = new int[10001];

        for(int i=0; i<N; i++) {
            counting[Integer.parseInt(br.readLine())]++;
        }
        StringBuilder result = new StringBuilder();

        for(int j=1; j<10001; j++) {
            while(counting[j]>0) {
                result.append(j).append("\n");
                counting[j]--;
            }
        }
        System.out.println(result);
    }
}