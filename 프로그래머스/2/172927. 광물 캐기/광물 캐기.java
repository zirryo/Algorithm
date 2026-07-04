import java.util.*;

class Solution {
    static class MineralGroup implements Comparable<MineralGroup> {
        int diaCnt = 0;
        int ironCnt = 0;
        int stoneCnt = 0;

        @Override
        public int compareTo(MineralGroup o) {
            if (this.diaCnt != o.diaCnt) {
                return Integer.compare(o.diaCnt, this.diaCnt);
            }
            if (this.ironCnt != o.ironCnt) {
                return Integer.compare(o.ironCnt, this.ironCnt);
            }
            return Integer.compare(o.stoneCnt, this.stoneCnt);
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        int totalMineralCnt = Math.min(minerals.length, totalPicks * 5);
        
        List<MineralGroup> groups = new ArrayList<>();
        
        for (int i = 0; i < totalMineralCnt; i += 5) {
            MineralGroup group = new MineralGroup();
            for (int j = i; j < i + 5 && j < totalMineralCnt; j++) {
                String mineral = minerals[j];
                if (mineral.equals("diamond")) group.diaCnt++;
                else if (mineral.equals("iron")) group.ironCnt++;
                else if (mineral.equals("stone")) group.stoneCnt++;
            }
            groups.add(group);
        }
        
        Collections.sort(groups);
        
        int totalFatigue = 0;
        
        for (MineralGroup g : groups) {
            if (picks[0] > 0) {
                totalFatigue += g.diaCnt * 1 + g.ironCnt * 1 + g.stoneCnt * 1;
                picks[0]--;
            } else if (picks[1] > 0) {
                totalFatigue += g.diaCnt * 5 + g.ironCnt * 1 + g.stoneCnt * 1;
                picks[1]--;
            } else if (picks[2] > 0) {
                totalFatigue += g.diaCnt * 25 + g.ironCnt * 5 + g.stoneCnt * 1;
                picks[2]--;
            } else {
                break;
            }
        }
        
        return totalFatigue;
    }
}