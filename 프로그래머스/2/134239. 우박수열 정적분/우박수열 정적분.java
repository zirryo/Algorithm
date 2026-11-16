import java.util.ArrayList;
import java.util.List;

class Solution {

    public double[] solution(int k, int[][] ranges) {
        List<Long> sequence = new ArrayList<>();
        long current = k;
        sequence.add(current);

        while (current > 1) {
            if (current % 2 == 0) {
                current /= 2;
            } else {
                current = current * 3 + 1;
            }
            sequence.add(current);
        }

        int n = sequence.size() - 1;

        double[] prefixSum = new double[n + 1];
        for (int i = 0; i < n; i++) {
            double trapezoidArea = (sequence.get(i) + sequence.get(i + 1)) / 2.0;
            prefixSum[i + 1] = prefixSum[i] + trapezoidArea;
        }

        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1]; 

            if (start > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefixSum[end] - prefixSum[start];
            }
        }

        return answer;
    }
}