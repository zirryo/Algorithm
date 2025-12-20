import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Long> even = new ArrayList<>();
        List<Long> odd = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(st.nextToken());
            if ((x & 1) == 0) even.add(x);
            else odd.add(x);
        }

        Collections.sort(even);
        Collections.sort(odd);

        long evenMin = Long.MAX_VALUE;
        long oddMin = Long.MAX_VALUE;

        for (int i = 0; i + 1 < even.size(); i++) {
            evenMin = Math.min(evenMin, even.get(i + 1) - even.get(i));
        }
        for (int i = 0; i + 1 < odd.size(); i++) {
            evenMin = Math.min(evenMin, odd.get(i + 1) - odd.get(i));
        }

        int i = 0, j = 0;
        while (i < even.size() && j < odd.size()) {
            long diff = Math.abs(even.get(i) - odd.get(j));
            oddMin = Math.min(oddMin, diff);

            if (even.get(i) < odd.get(j)) i++;
            else j++;
        }

        System.out.println(
            (evenMin == Long.MAX_VALUE ? -1 : evenMin) + " " +
            (oddMin == Long.MAX_VALUE ? -1 : oddMin)
        );
    }
}
