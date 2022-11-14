import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, root;
    static int leafs = 0;
    static int[] tree;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new int[N];
        isVisited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int k = Integer.parseInt(st.nextToken());
            if(k==-1) root = i;
            tree[i] = k;
        }

        int remove = Integer.parseInt(br.readLine()); // 삭제할 노드
        removeNode(remove); 
        cntLeafs(root); 
        System.out.println(leafs);
    }

    private static void removeNode(int idx) {
        tree[idx] = -2; // 루트 및 다른 노드와 구분

        for(int i=0; i<N; i++) {
            if(tree[i] == idx) removeNode(i); // 삭제한 노드의 자식 노드 삭제
        }
    }

    private static void cntLeafs(int idx) {
        boolean isLeaf = true;
        isVisited[idx] = true;
        if(tree[idx] != -2) {
            for(int i=0; i<N; i++) {
                if(tree[i] == idx && !isVisited[i]) {
                    cntLeafs(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) leafs++;
        }
    }
}