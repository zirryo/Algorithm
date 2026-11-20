class Solution {

    private static final int MAX_BLOCK = 10_000_000;

    public int[] solution(long begin, long end) {
        int length = (int) (end - begin + 1);
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = getBlockNumber(begin + i);
        }

        return answer;
    }

    private int getBlockNumber(long pos) {
        if (pos == 1) {
            return 0;
        }

        int maxDivisor = 1;

        for (long d = 2; d * d <= pos; d++) {
            if (pos % d == 0) {
                long pairedDivisor = pos / d;

                if (pairedDivisor <= MAX_BLOCK) {
                    return (int) pairedDivisor;
                }

                if (d <= MAX_BLOCK) {
                    maxDivisor = (int) d;
                }
            }
        }

        return maxDivisor;
    }
}