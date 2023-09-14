import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int result = 0;
        br.readLine();
        for (int i = 1; i < N; i++) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                result += set.size();
                set = new HashSet<>();
            } else {
                set.add(s);
            }
        }
        result += set.size();
        System.out.println(result);
    }
}