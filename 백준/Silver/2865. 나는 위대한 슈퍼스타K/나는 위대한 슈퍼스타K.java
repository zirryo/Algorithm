import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<double[]> scores = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                double skill = Double.parseDouble(st.nextToken());
                scores.add(new double[]{num, skill});
            }
        }

        scores.sort((a, b) -> Double.compare(b[1], a[1]));

        Map<Integer, Double> bestScore = new HashMap<>();
        for (double[] s : scores) {
            int num = (int) s[0];
            double skill = s[1];
            bestScore.putIfAbsent(num, skill);
        }

        List<Double> sortedScores = new ArrayList<>(bestScore.values());
        sortedScores.sort(Collections.reverseOrder());

        double sum = 0;
        for (int i = 0; i < K; i++) {
            sum += sortedScores.get(i);
        }

        System.out.printf("%.1f\n", sum);
    }
}
