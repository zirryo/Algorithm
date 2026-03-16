import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int plus = Integer.parseInt(st.nextToken());
        int work = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        int curFatigue = 0;
        long totalWork = 0;

        if (plus > limit) {
            System.out.println(0);
            return;
        }

        for (int hour = 0; hour < 24; hour++) {
            if (curFatigue + plus <= limit) {
                curFatigue += plus;
                totalWork += work;
            } else {
                curFatigue -= minus;
                if (curFatigue < 0) curFatigue = 0;
            }
        }

        System.out.println(totalWork);
    }
}