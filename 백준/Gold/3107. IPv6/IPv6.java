import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.contains("::")) str = str.replace("::", ":zeros:");

        List<String> original = Stream.of(str.split(":")).collect(Collectors.toList());
        List<String> restore = new ArrayList<>();
        
        for (String s : original) {
            if (s.length() == 0) continue;
            else if (s.length() == 1) s = "000" + s;
            else if (s.length() == 2) s = "00" + s;
            else if (s.length() == 3) s = "0" + s;
            restore.add(s);
        }

        String[] result = new String[8];
        int idx = 0;

        for (String s : restore) {
            if (s.equals("zeros")) {
                int zeroCnt = 8 - restore.size() + 1;
                while (zeroCnt-- > 0) {
                    result[idx++] = "0000";
                }
            } else result[idx++] = s;
        }

        System.out.println(String.join(":", result));
    }
}