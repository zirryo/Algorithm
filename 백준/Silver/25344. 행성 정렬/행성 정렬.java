import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long result = Long.parseLong(st.nextToken());

        for (int i = 0; i < N - 3; i++) {
            long nextT = Long.parseLong(st.nextToken());
            result = getLcm(result, nextT);
        }

        System.out.println(result);
    }

    static long getGcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static long getLcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / getGcd(a, b)) * b;
    }
}