import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());  // 리스트의 길이
        int M = Integer.parseInt(st.nextToken());  // 인덱스의 개수
        int P = Integer.parseInt(st.nextToken());  // 순환 시작 노드
        int loopLength = N - P + 1;
        int[] list = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < M; i++) {
            int K = Integer.parseInt(br.readLine());  // K번째 인덱스

            if (K < N) {
                // 순환 전에 위치하는 경우
                sb.append(list[K]).append("\n");
            } else {
                // 순환 부분에 위치하는 경우
                sb.append(list[(K - P + 1) % loopLength + P - 1]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
