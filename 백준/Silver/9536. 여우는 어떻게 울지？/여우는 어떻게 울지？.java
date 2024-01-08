import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Set<String> set = new TreeSet<>();
            String[] original = br.readLine().split(" ");
            String[] input;

            while (true) {
                input = br.readLine().split(" ");
                if (input[0].equals("what")) break;
                set.add(input[2]);
            }

            boolean[] fox = new boolean[original.length];
            for (int i=0; i< original.length; i++) {
                if (!set.contains(original[i])) fox[i] = true;
            }

            for (int i=0; i< original.length; i++) {
                if (fox[i]) sb.append(original[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}