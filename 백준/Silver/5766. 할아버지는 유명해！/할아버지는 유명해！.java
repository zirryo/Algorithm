import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 주 수
            int M = Integer.parseInt(st.nextToken()); // 매주 랭커 수

            if (N == 0 && M == 0) break;

            Map<Integer, Integer> scoreMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int player = Integer.parseInt(st.nextToken());
                    scoreMap.put(player, scoreMap.getOrDefault(player, 0) + 1);
                }
            }

            int maxScore = Collections.max(scoreMap.values());

            int secondMax = Integer.MIN_VALUE;
            for (int score : scoreMap.values()) {
                if (score < maxScore) {
                    secondMax = Math.max(secondMax, score);
                }
            }

            List<Integer> secondPlace = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {
                if (entry.getValue() == secondMax) {
                    secondPlace.add(entry.getKey());
                }
            }

            Collections.sort(secondPlace);
            for (int i = 0; i < secondPlace.size(); i++) {
                sb.append(secondPlace.get(i));
                if (i < secondPlace.size() - 1) sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
