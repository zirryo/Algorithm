class Solution {
    int[] order;
    int[][] d;
    boolean[] visited;
    int N, K, ans = 0;
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        K = k;
        d = dungeons;
        order = new int[N];
        visited = new boolean[N];

        dfs(0);
        return ans;
    }
    private void dfs(int depth) {
        if (depth == N) {
            adventure();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            order[depth] = i;
            dfs(depth+1);
            visited[i] = false;
            order[depth] = 0;
        }
    }
    private void adventure() {
        int temp = K;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (temp < d[order[i]][0]) break;
            temp -= d[order[i]][1];
            cnt++;
        }
        ans = Math.max(ans, cnt);
    }
}