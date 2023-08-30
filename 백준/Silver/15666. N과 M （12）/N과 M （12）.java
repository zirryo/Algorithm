import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static ArrayList<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        dfs(0, 0, "");
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int idx, int depth, String str) {
        if (depth == M) {
            list.add(str);
            return;
        }

        int pre = 0;
        for (int i = idx; i < N; i++) {
            if (pre == arr[i]) continue;
            pre = arr[i];
            dfs(i, depth + 1, str + arr[i] + " ");
        }
    }
}