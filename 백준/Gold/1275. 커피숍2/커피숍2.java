import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static long[] arr;
    static long[] segTree;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        init();
        StringTokenizer st;

        while(Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long val;
            if(x <= y) val = sum(1, N, x, y, 1);
            else val = sum(1, N, y, x, 1);

            sb.append(val).append("\n");

            if(Q == 0) break;
            long diff = b - arr[a];
            update(1, N, 1, a, diff);
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        segTree = new long[4*N];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        makeTree(1, N, 1);
    }
    private static long makeTree(int s, int e, int node) {
        // 구간합 트리 -  O(logN)
        // 원래 데이터의 범위를 반씩 분할하여 그 구간의 합을 저장하는 배열을 생성함.
        if(s == e) return segTree[node] = arr[s];
        int mid = (s + e) / 2;
        return segTree[node] = makeTree(s, mid, node*2) + makeTree(mid+1, e, node*2+1);
    }
    private static long sum(int s, int e, int l, int r, int node) {
        // s : 시작 인덱스, e : 끝 인덱스, l ~ r : 구간 합 범위
        if(l > e || r < s) return 0; // 범위 밖에 있는 경우
        if(l <= s && r >= e) return segTree[node]; // 범위 안에 있는 경우

        int mid = (s + e) / 2;
        return sum(s, mid, l, r, node*2) + sum(mid+1, e, l, r, node*2 + 1);
    }

    private static void update(int s, int e, int node, int idx, long diff) {
        // idx : arr 에서의 인덱스, diff : 기존 값과 변경 값의 차이
        if(idx < s || idx > e) return; // 범위 밖에 있는 경우

        segTree[node] += diff;
        if(s == e) { // 리프 노드인 경우
            arr[idx] = segTree[node]; // 다음 diff 에서 arr 값을 참고하므로 기존 배열의 값도 변경
            return;
        }

        int mid = (s + e) / 2;

        update(s, mid, node*2, idx, diff);
        update(mid+1, e, node*2 + 1, idx, diff);
    }
}