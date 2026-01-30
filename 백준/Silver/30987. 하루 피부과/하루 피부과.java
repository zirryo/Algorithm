import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        long e = Long.parseLong(st.nextToken());

        // h(x) = Ax^2 + Bx + C = ax^2 + (b-d)x + (c-e)
        long A = a;
        long B = b - d;
        long C = c - e;

        // H(x) = (A/3)x^3 + (B/2)x^2 + Cx
        long result = calculate(x2, A, B, C) - calculate(x1, A, B, C);

        System.out.println(result);
    }

    static long calculate(long x, long A, long B, long C) {
        return (A / 3) * x * x * x + (B / 2) * x * x + C * x;
    }
}