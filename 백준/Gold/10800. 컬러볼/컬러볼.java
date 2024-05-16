import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Ball {
        int index;
        int color;
        int size;

        Ball(int index, int color, int size) {
            this.index = index;
            this.color = color;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Ball[] balls = new Ball[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i, color, size);
        }

        // 공 크기 기준으로 정렬 (크기 오름차순, 크기 같다면 색상 기준)
        Arrays.sort(balls, (a, b) -> {
            if (a.size == b.size) {
                return a.color - b.color;
            }
            return a.size - b.size;
        });

        int[] result = new int[N];
        int[] colorSum = new int[N + 1];
        int totalSum = 0;
        int j = 0;

        for (int i = 0; i < N; i++) {
            // 크기 같은 공들 처리
            while (balls[j].size < balls[i].size) {
                totalSum += balls[j].size;
                colorSum[balls[j].color] += balls[j].size;
                j++;
            }
            result[balls[i].index] = totalSum - colorSum[balls[i].color];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }
}