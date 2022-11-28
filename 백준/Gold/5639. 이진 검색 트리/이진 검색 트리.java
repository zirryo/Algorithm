import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new ArrayList<>();

        String s;
        while((s = br.readLine()) != null) list.add(Integer.parseInt(s));

        dfs(0, list.size()-1);
        System.out.println(sb);

    }
    static void dfs(int left, int right) {
        if(left > right) return;
        int mid = left + 1; // 왼쪽 트리와 오른쪽 트리가 나눠지는 지점

        while(mid <=right && list.get(mid) < list.get(left)) mid++;

        dfs(left+1, mid-1);
        dfs(mid, right);

        sb.append(list.get(left)).append("\n");
    }

}