import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(br.readLine().trim());
        }

        Collections.sort(arr, (x, y) -> {
            if (x.length() != y.length()) return x.length() - y.length();
            return x.compareTo(y);
        });
        ArrayList<String> cand = new ArrayList<>();

        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    cand.add(arr.get(i) + arr.get(j));
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == j) continue;
                    cand.add(arr.get(i) + arr.get(j));
                }
            }
        }

        Collections.sort(cand, (x, y) -> {
            if (x.length() != y.length()) return x.length() - y.length();
            return x.compareTo(y);
        });

        System.out.println(cand.get(2));
    }
}
