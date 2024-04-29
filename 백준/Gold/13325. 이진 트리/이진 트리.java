import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int size, result = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        size = (int) Math.pow(2, N+1);
        arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1);
        System.out.println(result);
    }
    private static int dfs(int node) {
        if (node * 2>= size) { // 리프노드인 경우
            result += arr[node];
            return arr[node];
        } else { // 리프노드 아닌 경우
            int l = dfs(node * 2);
            int r = dfs(node * 2 + 1);

            result += arr[node] + Math.abs(l - r);
            return arr[node] + Math.max(l, r);
        }
    }
}