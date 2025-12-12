import java.io.*;
import java.util.*;

public class Main {

    static String preorder, inorder;
    static Map<Character, Integer> inIndex; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            preorder = st.nextToken();
            inorder = st.nextToken();

            int n = preorder.length();
            inIndex = new HashMap<>();

            for (int i = 0; i < n; i++) {
                inIndex.put(inorder.charAt(i), i);
            }

            sb.append(build(0, n - 1, 0, n - 1))
                    .append('\n');
        }

        System.out.print(sb);
    }

    static String build(int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) return "";

        char root = preorder.charAt(preL);
        int rootIdx = inIndex.get(root);

        int leftSize = rootIdx - inL;

        // Left subtree + Right subtree + Root
        String left = build(preL + 1, preL + leftSize, inL, rootIdx - 1);
        String right = build(preL + leftSize + 1, preR, rootIdx + 1, inR);

        return left + right + root;
    }
}
