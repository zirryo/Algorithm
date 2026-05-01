import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> degrees = new HashMap<>();
        int maxNode = 0;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            degrees.putIfAbsent(from, new int[2]);
            degrees.putIfAbsent(to, new int[2]);
            
            degrees.get(from)[0]++;
            degrees.get(to)[1]++;
            
            maxNode = Math.max(maxNode, Math.max(from, to));
        }

        int createdNode = -1;
        int donutCount = 0;
        int barCount = 0;
        int eightCount = 0;

        for (int node : degrees.keySet()) {
            int[] d = degrees.get(node);
            int out = d[0];
            int in = d[1];

            if (out >= 2 && in == 0) {
                createdNode = node;
            }
            else if (out == 0 && in >= 0) {
                barCount++;
            }

            else if (out == 2 && in >= 2) {
                eightCount++;
            }
        }

        int totalGraphs = degrees.get(createdNode)[0];
        donutCount = totalGraphs - barCount - eightCount;

        return new int[]{createdNode, donutCount, barCount, eightCount};
    }
}