import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> inOffice = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            if (input[1].equals("leave")) {
                inOffice.remove(input[0]);
            } else {
                inOffice.add(input[0]);
            }
        }

        StringBuilder sb = new StringBuilder();
        inOffice.stream()
                .sorted(Collections.reverseOrder())
                .forEach(x -> sb.append(x).append("\n"));

        System.out.println(sb);
    }
}