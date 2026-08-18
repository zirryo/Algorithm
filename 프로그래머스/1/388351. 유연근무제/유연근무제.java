class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;

        for (int i = 0; i < n; i++) {
            int deadline = getDeadline(schedules[i]);
            boolean isEligible = true;

            for (int j = 0; j < 7; j++) {
                int currentDay = (startday - 1 + j) % 7 + 1;

                if (currentDay == 6 || currentDay == 7) {
                    continue;
                }

                if (timelogs[i][j] > deadline) {
                    isEligible = false;
                    break;
                }
            }

            if (isEligible) {
                answer++;
            }
        }

        return answer;
    }

    private int getDeadline(int schedule) {
        int hour = schedule / 100;
        int min = schedule % 100 + 10;

        if (min >= 60) {
            hour++;
            min -= 60;
        }

        return hour * 100 + min;
    }
}