import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long totalEdges = N * (N - 1) / 2;

        if (N % 2 != 0) { // 오일러 회로 구성 -> 간선의 수는 NC2
            System.out.println(totalEdges);
        } else {
            /* N이 짝수인 경우
                - 오일러 경로가 성립하려면 홀수 차수의 정점이 0개 혹은 2개여야 함.
                - 즉, N개의 홀수 차수 정점 2개(시작점, 종점) 제외 후 다른 정점의 차수를 짝수로 만들어야 함.
                - 추가 간선 생성으로 차수 보정. (N-2)/2 개의 간선 추가.
             */
            long extraEdges = (N - 2) / 2;
            System.out.println(totalEdges + extraEdges);
        }
    }
}