import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) list.add(i);
        }

        if (list.size() < K) {
            System.out.println(-1);
            System.exit(0);
        }

        int result = N;
        int s = 0;
        int e = K - 1;

        while (e < list.size()) {
            result = Math.min(result, list.get(e) - list.get(s) + 1);
            s++;
            e++;
        }

        System.out.println(result);
    }
}