import java.util.*;

class Solution {
    List<Integer>[] adjList;

    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            int count = bfs(v1, v2, n);
            int diff = Math.abs(count - (n - count));
            minDiff = Math.min(minDiff, diff);
        }
        
        return minDiff;
    }
    
    private int bfs(int start, int cut, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        visited[start] = true;
        int count = 1;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            
            for (int next : adjList[current]) {
                if (visited[next] || next == cut) {
                    continue;
                }
                
                visited[next] = true;
                q.add(next);
                count++;
            }
        }
        
        return count;
    }
}