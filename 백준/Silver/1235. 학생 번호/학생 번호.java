import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }
        int LEN = arr[0].length();

        Arrays.sort(arr);
        Set<String> set;
        for (int i = 1; i <= LEN; i++) {
            set = new TreeSet<>();
            for (int j = 0; j < N; j++) {
                if (!set.add(arr[j].substring(LEN-i))) {
                    break;
                }
            }

            if (set.size() == N) {
                System.out.println(i);
                return;
            }
        }
    }
}