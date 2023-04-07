import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int bridges = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Pool[] pools = new Pool[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pools[i] = new Pool(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(pools);

        int rightEdge = -1;
        for(int i = 0; i < N; i++) {
            if(rightEdge <= pools[i].s) {
                rightEdge = getRight(pools[i].s, pools[i].e);
            } else if(rightEdge < pools[i].e) {
                rightEdge = getRight(rightEdge, pools[i].e);
            }
            if(rightEdge >= pools[N-1].e) break;
        }
        System.out.println(bridges);
    }
    private static int getRight(int s, int e) {
        int cnt = (int) Math.ceil((e - s) /(double) L);
        bridges += cnt;
        return s + cnt * L;
    }
    private static class Pool implements Comparable<Pool> {
        int s;
        int e;

        public Pool(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Pool pool) {
            return this.s - pool.s;
        }
    }
}