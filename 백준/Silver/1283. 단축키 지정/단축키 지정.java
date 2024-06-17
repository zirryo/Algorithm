import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            boolean assigned = false;
            for (int j = 0; j < input.length; j++) {
                int first = Character.toLowerCase(input[j].charAt(0)) - 'a';
                if (!used[first]) {
                    used[first] = true;
                    assigned = true;
                    input[j] = "[" + input[j].charAt(0) + "]" + input[j].substring(1);
                    break;
                }
            }

            if (!assigned) {
                Outer:
                for (int j = 0; j < input.length; j++) {
                    for (int k = 1; k < input[j].length(); k++) {
                        int exceptFirst = Character.toLowerCase(input[j].charAt(k)) - 'a';
                        if (!used[exceptFirst]) {
                            used[exceptFirst] = true;
                            assigned = true;
                            input[j] = input[j].substring(0, k) + "["
                                    + input[j].charAt(k) + "]" + input[j].substring(k + 1);
                            break Outer;
                        }
                    }
                }
            }


            sb.append(String.join( " ", input)).append("\n");
        }
        System.out.println(sb);
    }
}