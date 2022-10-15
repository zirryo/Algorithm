import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            int[] applicant = new int[N+1];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int form = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                applicant[form] = interview; // 서류 순위로 지원자를 정렬
            }
            int temp = applicant[1];
            int cnt = 1;

            for(int i=2; i<=N; i++) {
                if(applicant[i] < temp) {
                    temp = applicant[i];
                    cnt++;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}