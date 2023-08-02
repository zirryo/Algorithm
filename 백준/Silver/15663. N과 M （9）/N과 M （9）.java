import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, "");


        for (String s : list) {
            sb.append(s);
            sb.append("\n");
        }

        System.out.println(sb);
    }
    private static void dfs(int depth, String str) {
        if (depth == M) {
            list.add(str);
            return;
        }

        int pre = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i] || pre == arr[i]) continue;
            visited[i] = true;
            pre = arr[i]; // 같은 수열 생성 방지
            dfs(depth + 1, str + arr[i] + " ");
            visited[i] = false;
        }
    }
}