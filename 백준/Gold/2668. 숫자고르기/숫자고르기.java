import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N, start;
    static int[] arr;
    static boolean[] isVisited;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        isVisited = new boolean[N+1];
        isVisited[0] = true; // 생략 가능하나 명시함.

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N; i++) {
            isVisited[i] = true;
            start = i; // dfs 의 출발점 저장
            dfs(i);
            isVisited[i] = false;
        }

        sb.append(list.size()).append("\n");
        Collections.sort(list);
        for(Integer I : list) sb.append(I).append("\n");
        System.out.println(sb);
    }
    static void dfs(int i) {
        if(arr[i] == start) {
            list.add(start);
        }

        if(!isVisited[arr[i]]) {
            isVisited[arr[i]] = true;
            dfs(arr[i]);
            isVisited[arr[i]] = false;
        }
    }
}