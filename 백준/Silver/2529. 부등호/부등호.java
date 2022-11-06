import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static boolean[] isVisited = new boolean[10];
    static char[] inequality;
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        inequality = new char[K];
        for(int i=0; i<K; i++) inequality[i] = st.nextToken().charAt(0);

        dfs("", 0);
        Collections.sort(result);
        System.out.println(result.get(result.size()-1)); // 최대 정수
        System.out.println(result.get(0)); // 최소 정수

    }

    private static void dfs(String s, int depth) {
        if(depth == K + 1) {
            result.add(s);
            return;
        }

        for(int i=0; i<=9; i++) {
            if(depth == 0 || (!isVisited[i] && compare(s.charAt(s.length()-1) - '0', i, inequality[depth-1]))) {
                isVisited[i] = true;
                dfs(s + i, depth+1);
                isVisited[i] = false;
            }
        }
    }

    private static boolean compare(int a, int b, char c) {
        if(c == '<') return a < b;
        else return a > b;
    }

}