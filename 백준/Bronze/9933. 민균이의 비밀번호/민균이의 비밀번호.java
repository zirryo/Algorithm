import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> wordSet = new HashSet<>();
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            wordSet.add(words[i]);
        }

        for (String s : words) {
            String reversed = new StringBuilder(s).reverse().toString();

            if (wordSet.contains(reversed)) {
                int len = s.length();
                char middle = s.charAt(len / 2);

                System.out.println(len + " " + middle);
                break;
            }
        }
    }
}