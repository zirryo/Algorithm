import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 리스트에 등록된 점수의 개수
        int M = Integer.parseInt(st.nextToken()); // 태수의 점수
        int P = Integer.parseInt(st.nextToken()); // 랭킹에 등재 가능한 점수의 개수

        if (N == 0) System.out.println(1);
        else {
            int[] arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int rank = 1;
            while (rank <= N) {
                if (M < arr[rank]) rank++;
                else break;
            }

            if (N == P && M <= arr[N]) {
                System.out.println(-1);
            } else {
                System.out.println(rank);
            }

        }
    }
}