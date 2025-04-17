import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new TreeSet<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;

        for (int i = 0; i < M; i++) {
            if (!set.contains(arr[i])) {
                result++;
            }
        }

        System.out.println(result);

    }
}