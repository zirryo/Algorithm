import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int fish = (2 * i + j) % 5 + 1;
                sb.append(fish).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    /* 라틴 방진(Latin Square) 의 변형
    - 기본 특징 : 각 행과 열에 중복된 숫자 사용 X (스도쿠의 기본 규칙과 유사함)
    - 문제 상황에 맞게 변형 : 상하좌우에서 같은 수가 겹치지 않도록 계수를 추가하여 기울어진 라틴 방진 설계
     */
}