import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int totalWeight = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int truckIdx = 0;
        
        while (truckIdx < truck_weights.length) {
            time++;
            totalWeight -= bridge.poll();
            
            int nextWeight = truck_weights[truckIdx];
            if (totalWeight + nextWeight <= weight) {
                bridge.add(nextWeight);
                totalWeight += nextWeight;
                truckIdx++; 
            } else {
                bridge.add(0);
            }
        }

        return time + bridge_length;
    }
}