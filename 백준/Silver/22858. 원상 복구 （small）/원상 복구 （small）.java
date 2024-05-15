import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] curCard = new int[N+1];
        int[] movePos = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            curCard[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            movePos[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i=0; i<K; i++) {
            int[] temp = new int[N+1];
            for (int j=1; j<=N; j++) {
                temp[movePos[j]] = curCard[j];
            }
            curCard = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            sb.append(curCard[i]).append(" ");
        }
        System.out.println(sb);
    }
}