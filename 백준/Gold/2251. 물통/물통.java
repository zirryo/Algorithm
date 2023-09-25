import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int A, B, C;
    static boolean[][] visited;
    static Set<Integer> volC;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        volC = new TreeSet<>();
        visited = new boolean[201][201];
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dfs(0, 0, C);
        for (int x : volC) sb.append(x).append(" ");

        System.out.println(sb);
    }
    static void dfs(int a, int b, int c) {
        if (visited[a][b]) return;
        if (a == 0) volC.add(c);
        visited[a][b] = true;

        // A -> B
        if (a + b <= B) dfs(0, a+b, c);
        else dfs(a+b-B, B, c);

        // A -> C
        if (a + c <= C) dfs(0, b, a+c);
        else dfs(a+c-C, b, C);

        // B -> A
        if (b + a <= A) dfs(b+a, 0, c);
        else dfs(A, b+a-A, c);

        // B -> C
        if (b + c <= C) dfs(a, 0, b+c);
        else dfs(a, b+c-C, C);

        // C -> A
        if (c + a <= A) dfs(a+c, b, 0);
        else dfs(A, b, c+a-A);

        // C -> B
        if (c + b <= B) dfs(a, c+b, 0);
        else dfs(a, B, c+b-B);
    }
}