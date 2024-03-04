import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < L; i++) {
            map.put(br.readLine(), i);
        }

        List<String> keylist = new ArrayList<>(map.keySet());
        keylist.sort(Comparator.comparing(map::get));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(N, keylist.size()); i++) {
            sb.append(keylist.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}