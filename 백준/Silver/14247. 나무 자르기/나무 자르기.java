import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] trees = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees, Comparator.comparingInt(o -> o[1])); // 자라나는 길이를 기준으로 오름차순 정렬

        long totalHeight = 0;
        for (int i = 0; i < N; i++) {
            totalHeight += (long) trees[i][0] + (long) i * trees[i][1];
        }

        System.out.println(totalHeight);
    }
}

/*
가중치가 적은 나무부터 -> 큰 나무 순으로 매일 다른 나무를 자르는 것이 가장 많은 나무를 구하는 방법.
 */
