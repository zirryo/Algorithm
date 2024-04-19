import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[] ori, anagram;
    static boolean[] visited;
    static int len;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            ori = br.readLine().toCharArray();
            len = ori.length;
            anagram = new char[len];
            visited = new boolean[len];
            Arrays.sort(ori);
            dfs(0);
        }
        System.out.println(sb);

    }
    private static void dfs(int depth) {
        if (depth == len) {
            for (char c : anagram) {
                sb.append(c);
            }
            sb.append("\n");
        } else {
            char prev = ' ';
            for (int i = 0; i < len; i++) {
                if (ori[i] != prev && !visited[i]) {
                    anagram[depth] = ori[i];
                    visited[i] = true;
                    prev = ori[i];
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}