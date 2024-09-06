import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<String, Double> score = new HashMap<>();
        score.put("A+", 4.5);
        score.put("A0", 4.0);
        score.put("B+", 3.5);
        score.put("B0", 3.0);
        score.put("C+", 2.5);
        score.put("C0", 2.0);
        score.put("D+", 1.5);
        score.put("D0", 1.0);
        score.put("F", 0.0);

        double totalTime = 0;
        double totalScore = 0;

        for (int i=0; i<20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double a = Double.parseDouble(st.nextToken());
            String s = st.nextToken();
            if (s.equals("P")) continue;
            totalTime += a;
            totalScore += (score.get(s) * a);
        }

        double result = totalScore / totalTime;
        System.out.println(result);
    }
}
