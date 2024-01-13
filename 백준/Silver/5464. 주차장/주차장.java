import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 주차공간의 수
        int M = Integer.parseInt(st.nextToken()); // 차량의 수
        int[] cost = new int[N+1]; // 주차 공간들의 단위 무게당 요금
        int[] weight = new int[M+1]; // 차량의 무게
        int[] parking = new int[N+1]; // 주차현황
        Queue<Integer> waiting = new LinkedList<>(); // 대기열
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= M; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        Outer:
        for (int i = 0; i< 2*M; i++) {
            int X = Integer.parseInt(br.readLine());
            if (X > 0) { // 입차
                 for (int j = 1; j <= N; j++) {
                     if (parking[j] == 0) {
                         parking[j] = X;
                         continue Outer;
                     }
                 }
                 waiting.add(X);
            } else { // 출차
                X *= (-1);
                for (int j = 1; j <= N; j++) {
                    if (parking[j] == X) {
                        parking[j] = 0;
                        result += cost[j] * weight[X];
                        if (!waiting.isEmpty()) {
                            parking[j] = waiting.poll();
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(result);

    }
}