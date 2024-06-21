import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] first = br.readLine().split(" ");
            String[] second = br.readLine().split(" ");
            String[] code = br.readLine().split(" ");
            HashMap<String, Integer> map = new HashMap<>();
            for (int i=0; i<N; i++) {
                map.put(first[i], i);
            }

            String[] result = new String[N];
            for (int i=0; i<N; i++) {
                result[map.get(second[i])] = code[i];
            }
            for (String s : result) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}