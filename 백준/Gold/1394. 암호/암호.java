import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 900528;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String wordset = br.readLine();
        String password = br.readLine();

        int L = wordset.length();
        int N = password.length();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < L; i++) {
            map.put(wordset.charAt(i), i);
        }

        long result = 0L;
        long power = 1;

        for (int i = 1; i < N; i++) {
            power = (power * L) % MOD;
            result = (result + power) % MOD;
        }

        long nLenTries = 0;
        for (int i = 0; i < N; i++) {
            int val = map.get(password.charAt(i));
            nLenTries = (nLenTries * L + val) % MOD;
        }

        result = (result + nLenTries + 1) % MOD; // 인덱스가 0부터 시작하므로 +1

        System.out.println(result);
    }
}