import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min = 0;
        int max = 0;
        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        while(min < max) {
            int mid = (min + max) / 2;
            long total = 0;

            for(int tree : trees) {
                if(tree - mid > 0) total += (tree - mid);
            }

            if(total < M) max = mid;
            else min = mid +1;
        }
        System.out.println(min-1); // Upperbound -> -1
    }
}