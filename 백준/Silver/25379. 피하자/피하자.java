import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }

        long oddToFront = 0;
        for (int i = 0; i < odd.size(); i++) {
            oddToFront += Math.abs(odd.get(i) - i);
        }

        long evenToFront = 0;
        for (int i = 0; i < even.size(); i++) {
            evenToFront += Math.abs(even.get(i) - i);
        }

        System.out.println(Math.min(oddToFront, evenToFront));
    }
}
