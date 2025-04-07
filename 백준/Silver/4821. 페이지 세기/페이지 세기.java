import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();

        while (true) {
            line = br.readLine();
            if (line.equals("0")) break;

            int maxPage = Integer.parseInt(line);
            String[] ranges = br.readLine().split(",");

            Set<Integer> pagesToPrint = new HashSet<>();

            for (String range : ranges) {
                range = range.trim();

                if (range.contains("-")) {
                    String[] parts = range.split("-");
                    int start = Integer.parseInt(parts[0]);
                    int end = Integer.parseInt(parts[1]);

                    if (start > end) continue;

                    int from = Math.max(1, start);
                    int to = Math.min(maxPage, end);

                    for (int i = from; i <= to; i++) {
                        pagesToPrint.add(i);
                    }
                } else {
                    int page = Integer.parseInt(range);
                    if (page >= 1 && page <= maxPage) {
                        pagesToPrint.add(page);
                    }
                }
            }

            sb.append(pagesToPrint.size()).append("\n");
        }

        System.out.println(sb);
    }
}
