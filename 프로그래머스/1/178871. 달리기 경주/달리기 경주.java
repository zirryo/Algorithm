import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        for (String calling : callings) {
            int currentRank = rankMap.get(calling);
            int prevRank = currentRank - 1;
            String prevPlayer = players[prevRank];

            players[prevRank] = calling;
            players[currentRank] = prevPlayer;

            rankMap.put(calling, prevRank);
            rankMap.put(prevPlayer, currentRank);
        }

        return players;
    }
}