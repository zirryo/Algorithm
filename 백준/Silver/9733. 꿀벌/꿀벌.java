import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> countMap = new HashMap<>();
        String[] jobs = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};

        for (String job : jobs) {
            countMap.put(job, 0);
        }

        String line;
        int total = 0;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);

            while (st.hasMoreTokens()) {
                total++;
                String work = st.nextToken();
                if (countMap.containsKey(work)) {
                    countMap.put(work, countMap.get(work) + 1);

                }
            }
        }

        for (String job : jobs) {
            int cnt = countMap.get(job);
            double ratio = total == 0 ? 0.0 : (double) cnt / total;
            System.out.printf("%s %d %.2f\n", job, cnt, ratio);
        }

        System.out.printf("Total %d 1.00\n", total);
    }
}
