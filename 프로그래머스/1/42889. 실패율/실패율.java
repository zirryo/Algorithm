import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static class Stage implements Comparable<Stage> {

        int stageNum;
        double failureRate;

        public Stage(int stageNum, double failureRate) {
            this.stageNum = stageNum;
            this.failureRate = failureRate;
        }

        @Override
        public int compareTo(Stage o) {
            if (Double.compare(o.failureRate, this.failureRate) != 0) {
                return Double.compare(o.failureRate, this.failureRate);
            }
            return Integer.compare(this.stageNum, o.stageNum);
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] count = new int[N + 2];
        for (int stage : stages) {
            count[stage]++;
        }

        List<Stage> stageList = new ArrayList<>();
        int totalPlayers = stages.length; 

        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                stageList.add(new Stage(i, 0.0));
            } else {
                double failureRate = (double) count[i] / totalPlayers;
                stageList.add(new Stage(i, failureRate));
                totalPlayers -= count[i]; 
            }
        }

        Collections.sort(stageList);

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).stageNum;
        }

        return answer;
    }
}