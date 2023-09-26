import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int lo = 1;
        int hi = 1;
        List<Integer> result = new ArrayList<>();

        while (true) {
            int diff = (hi * hi) - (lo * lo);

            if (hi - lo == 1 && diff > G) break;

            if (diff < G) hi++;
            else {
                if (diff == G) result.add(hi);
                lo++;
            }
        }

        if (result.size() == 0) {
            System.out.println(-1);
        } else {
            for (int x : result) sb.append(x).append("\n");
        }

        System.out.print(sb);
    }
}