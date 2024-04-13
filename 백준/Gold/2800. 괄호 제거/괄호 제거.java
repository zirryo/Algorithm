import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    static List<int[]> idxList;
    static List<String> result;
    static boolean[] deleted;
    static char[] original;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        idxList = new ArrayList<>();
        result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        String input = br.readLine();
        original = input.toCharArray();
        deleted = new boolean[input.length()];

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                idxList.add(new int[]{stack.pop(), i});
            }
        }

        deleteBracket(0);

        StringBuilder ans = new StringBuilder();
        result.stream().distinct().sorted().forEach(s -> ans.append(s).append("\n"));
        System.out.println(ans);
    }
    private static void deleteBracket(int depth) {
        if (depth == idxList.size()) {
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < original.length; i++) {
                if (deleted[i]) flag = true;
                else sb.append(original[i]);
            }

            if (flag) result.add(sb.toString());
            return;
        }

        deleteBracket(depth + 1);
        int[] cur = idxList.get(depth);
        deleted[cur[0]] = true;
        deleted[cur[1]] = true;
        deleteBracket(depth + 1);
        deleted[cur[0]] = false;
        deleted[cur[1]] = false;
    }
}