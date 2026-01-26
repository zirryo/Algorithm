import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long k = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        long leftLimit = a * k + b;
        long rightLimit = c * k + d;

        if (leftLimit == rightLimit) {
            System.out.println("Yes " + leftLimit);
        } else {
            System.out.println("No");
        }
    }
}