import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    static int G, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        parent = new int[G+1];

        for(int i=1; i<=G; i++) {
            parent[i] = i;
        }

        int result = 0;

        while(P-- > 0) {
            int gi = Integer.parseInt(br.readLine());
            int docking = find(gi);

            if(docking == 0) break;

            result++;
            union(docking, docking-1);
        }
        System.out.println(result);
    }
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) parent[rootA] = b;
    }
    static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}