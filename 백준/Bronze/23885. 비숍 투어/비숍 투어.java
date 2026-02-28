import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long sx = Long.parseLong(st.nextToken());
        long sy = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long ex = Long.parseLong(st.nextToken());
        long ey = Long.parseLong(st.nextToken());
        
        if (sx == ex && sy == ey) {
            System.out.println("YES");
        } else if (N == 1 || M == 1) {
            System.out.println("NO");
        } else if ((sx + sy) % 2 == (ex + ey) % 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}