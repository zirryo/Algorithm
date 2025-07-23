import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            List<String> tallestStudents = new ArrayList<>();
            double maxHeight = -1.0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                double height = Double.parseDouble(st.nextToken());

                if (height > maxHeight) {
                    tallestStudents.clear();
                    tallestStudents.add(name);
                    maxHeight = height;
                } else if (height == maxHeight) {
                    tallestStudents.add(name);
                }
            }

            for (String name : tallestStudents) {
                sb.append(name).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
