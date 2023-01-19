import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] arr;
    static long[] segtree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        M += Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        segtree = new long[4*N];

        for(int i=1; i<=N; i++) arr[i] = Long.parseLong(br.readLine());
        init(1, N, 1);

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            switch (a) {
                case 1: { // 변경
                    long diff = c - arr[b];
                    update(1, N, 1, b, diff);
                    break;
                }
                case 2 : { // 구간 합
                    long val = sum(1, N, b, c, 1);
                    sb.append(val).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
    private static long init(int s, int e, int node) {
        // 구간합 트리 -  O(logN)
        // 원래 데이터의 범위를 반씩 분할하여 그 구간의 합을 저장하는 배열 생성
        if(s == e) return segtree[node] = arr[s];

        int mid = (s + e) / 2;
        return segtree[node] = init(s, mid, node*2) + init(mid+1, e, node*2 + 1);
        // 루트 인덱스는 1, 왼쪽 자식은 부모*2, 오른쪽 자식은 부모*2 + 1
    }

    private static long sum(int s, int e, int l, long r, int node) {
        // s : 시작 인덱스, e : 끝 인덱스, l ~ r : 구간 합 범위
        if(l > e || r < s) return 0; // 범위 밖에 있는 경우
        if(l <= s && r >= e) return segtree[node]; // 범위 안에 있는 경우

        int mid = (s + e) / 2;
        return sum(s, mid, l, r, node*2) + sum(mid+1, e, l, r, node*2 + 1);
    }

    private static void update(int s, int e, int node, int idx, long diff) {
        // idx : arr 에서의 인덱스, diff : 기존 값과 변경 값의 차이
        if(idx < s || idx > e) return; // 범위 밖에 있는 경우

        segtree[node] += diff;
        if(s == e) { // 리프 노드인 경우
            arr[idx] = segtree[node]; // 다음 diff 에서 arr 값을 참고하므로 기존 배열의 값도 변경
            return;
        }

        int mid = (s + e) / 2;

        update(s, mid, node*2, idx, diff);
        update(mid+1, e, node*2 + 1, idx, diff);
    }
}