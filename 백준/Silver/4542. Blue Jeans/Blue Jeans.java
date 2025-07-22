import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean isCommon(String sub, String[] sequences) {
        for (String s : sequences) {
            if (!s.contains(sub)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int datasetCount = Integer.parseInt(br.readLine());

        while (datasetCount-- > 0) {
            int m = Integer.parseInt(br.readLine());
            String[] dna = new String[m];

            for (int i = 0; i < m; i++) {
                dna[i] = br.readLine();
            }

            String base = dna[0];
            for (int i = 1; i < m; i++) {
                if (dna[i].length() < base.length()) {
                    base = dna[i];
                }
            }

            String result = "";
            outer:
            for (int len = base.length(); len >= 3; len--) {
                Set<String> candidates = new TreeSet<>();
                for (int i = 0; i <= base.length() - len; i++) {
                    String sub = base.substring(i, i + len);
                    candidates.add(sub);
                }

                for (String sub : candidates) {
                    if (isCommon(sub, dna)) {
                        result = sub;
                        break outer; 
                    }
                }
            }

            if (result.isEmpty()) {
                sb.append("no significant commonalities\n");
            } else {
                sb.append(result).append("\n");
            }

        }

        System.out.println(sb);
    }
}
