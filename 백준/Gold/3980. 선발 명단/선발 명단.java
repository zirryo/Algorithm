import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[][] ability;
    static int[] select;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            visited = new boolean[11];
            ability = new int[11][11];
            select = new int[11];
            result = 0;
            for (int i = 0; i < 11; i++) {
                ability[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            positionSelect(0);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    private static void positionSelect(int depth) {
        if (depth == 11) {
            findMaxAbility();
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (visited[i] || ability[i][depth] == 0) continue;
            visited[i] = true;
            select[depth] = i;
            positionSelect(depth+1);
            visited[i] = false;
        }
    }
    private static void findMaxAbility() {
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            sum += ability[select[i]][i];
        }

        result = Math.max(result, sum);
    }
}