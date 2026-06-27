class Solution {
    public int solution(int[] players, int m, int k) {
        int[] reduce = new int[50];
        int answer = 0;
        int expanded = 0;
        
        for (int i = 0; i < 24; i++) {
            int curServers = players[i] / m;
            expanded -= reduce[i];
            
            if (curServers > expanded) {
                int newServers = curServers - expanded;
                answer += newServers;
                reduce[i+k] = newServers;
                expanded += newServers;
            }   
        }
        
        return answer;
    }
}