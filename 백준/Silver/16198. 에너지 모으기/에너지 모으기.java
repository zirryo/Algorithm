import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> energy = new ArrayList<>();
        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(st.nextToken());
            energy.add(x);
        }

        dfs(energy, 0);
        System.out.println(result);
    }
    private static void dfs(List<Integer> list, int total) {
        if (list.size() <= 2 && result < total) {
            result = total;
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int x = list.get(i);
            int temp = list.get(i-1) * list.get(i+1);
            list.remove(i);
            dfs(list, total + temp);
            list.add(i, x);
        }
    }
}