import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] mintree;
    static int[] arr;
    static final int INF = 1_000_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        mintree = new int[4*N];
        arr = new int[N+1];

        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());
        init(1, N, 1); // mintree 생성

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = getMin(1, N, a, b, 1);
            sb.append(min).append("\n");

        }
        System.out.println(sb);
    }
    
    private static int init(int s, int e, int node) {
        if(s == e) {
            mintree[node] = arr[s];
            return arr[s];
        }

        int mid = (s + e) / 2;
        return mintree[node] = Math.min(init(s, mid, node*2), init(mid+1, e, node*2 + 1));
        // 루트 인덱스는 1, 왼쪽 자식은 부모*2, 오른쪽 자식은 부모*2 + 1
    }

    private static int getMin(int s, int e, int l, long r, int node) {
        // s : 시작 인덱스, e : 끝 인덱스, l ~ r : 범위
        if(l > e || r < s) return INF; // 범위 밖에 있는 경우
        if(l <= s && r >= e) return mintree[node]; // 범위 안에 있는 경우

        int mid = (s + e) / 2;
        return Math.min(getMin(s, mid, l, r, node*2), getMin(mid+1, e, l, r, node*2 + 1));
    }
}