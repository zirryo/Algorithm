import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Set<Integer> primes = new HashSet<>();

        for (String s : input) {
            int num = Integer.parseInt(s);
            if (isPrime(num)) {
                primes.add(num);
            }
        }

        if (primes.isEmpty()) {
            System.out.println(-1);
            return;
        }


        long lcm = 1;
        for (int prime : primes) {
            lcm *= prime;
        }

        System.out.println(lcm);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
