import java.io.*;
import java.util.*;

public class Main {
    static int N, columnIdx = 1;
    static int[] leftChild, rightChild, minCol, maxCol;
    static boolean[] isChild;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        leftChild = new int[N + 1];
        rightChild = new int[N + 1];
        isChild = new boolean[N + 1];
        minCol = new int[N + 1];
        maxCol = new int[N + 1];

        Arrays.fill(minCol, 10001);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            leftChild[node] = l;
            rightChild[node] = r;
            if (l != -1) isChild[l] = true;
            if (r != -1) isChild[r] = true;
        }

        int root = 1;
        for (int i = 1; i <= N; i++) {
            if (!isChild[i]) {
                root = i;
                break;
            }
        }

        inOrder(root, 1);

        int maxLevel = 0;
        int maxWidth = 0;

        for (int i = 1; i <= N; i++) {
            if (maxCol[i] == 0) break; // i 이상의 레벨이 없다는 의미 -> 탐색 종료
            int width = maxCol[i] - minCol[i] + 1;
            if (width > maxWidth) {
                maxWidth = width;
                maxLevel = i;
            }
        }

        System.out.println(maxLevel + " " + maxWidth);
    }

    // 중위 순회(Left -> Root -> Right)로 방문하는 순서가 열 번호
    static void inOrder(int node, int level) {
        if (node == -1) return;

        inOrder(leftChild[node], level + 1);

        minCol[level] = Math.min(minCol[level], columnIdx);
        maxCol[level] = Math.max(maxCol[level], columnIdx);
        columnIdx++;

        inOrder(rightChild[node], level + 1);
    }
}